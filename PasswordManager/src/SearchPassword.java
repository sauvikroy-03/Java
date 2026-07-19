import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
import javax.crypto.spec.SecretKeySpec;

public class SearchPassword {

    public void searchPassword(){
        Scanner sc = new Scanner(System.in);
        Properties properties = new Properties();
        ViewAllPasswords view = new ViewAllPasswords();

        try (var is = SearchPassword.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                System.out.println("[!] Error: Could not find config.properties inside your src folder.");
                return;
            }
            properties.load(is);
        } catch (Exception e) {
            System.out.println("[!] Configuration file error: " + e.getMessage());
            return;
        }

        view.getAllPasswords();
        System.out.println("Enter person's name : ");
        String name = sc.nextLine();
        System.out.println("Enter Site/App : ");
        String site = sc.nextLine();
        System.out.println("Enter Username: ");
        String username = sc.nextLine();

        // 1. Reconstruct the exact same AES key structure using SHA-256
        SecretKeySpec secretKey;
        try {
            String rawPhrase = properties.getProperty("app.secret");
            if (rawPhrase == null || rawPhrase.trim().isEmpty()) {
                System.out.println("[!] Error: app.secret is missing from config.properties");
                return;
            }
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = sha.digest(rawPhrase.getBytes(StandardCharsets.UTF_8));
            secretKey = new SecretKeySpec(keyBytes, "AES");
        } catch (Exception e) {
            System.out.println("[!] Secret key processing error: " + e.getMessage());
            return;
        }

        // 💡 Trap Fix 1: Explicitly ask for the target columns in the SELECT clause!
        String sql = "SELECT site, username, user_password FROM passwords WHERE person=? AND site=? AND username=?";

        // 💡 Trap Fix 2: Both Connection and PreparedStatement live safely inside the resource manager
        try (Connection conn = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, site);
            ps.setString(3, username);

            try (ResultSet rs = ps.executeQuery()) {
                boolean entryFound = false;

                while (rs.next()) {
                    entryFound = true;
                    String app = rs.getString("site");
                    String u_name = rs.getString("username");

                    // 2. Fetch the scrambled Base64 string from the column
                    String encryptedPassword = rs.getString("user_password");

                    // 3. Decrypt it back to plain text using your tool
                    String decryptedPassword = EncryptDecrypt.decrypt(encryptedPassword, secretKey);

                    // 4. Print the output nicely formatted
                    System.out.println("\n----------------------------------------");
                    System.out.println("Site/App : " + app);
                    System.out.println("Username : " + u_name);
                    System.out.println("Password  : " + decryptedPassword);
                    System.out.println("----------------------------------------\n");
                }

                if (!entryFound) {
                    System.out.println("\n[!] No matching records found for that input configuration.\n");
                }
            }

        } catch (Exception e) {
            System.out.println("[!] Database Error: " + e.getMessage());
        }
    }
}