import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;
import javax.crypto.spec.SecretKeySpec;

public class AddPassword {
    String person;
    String site;
    String username;
    String password;

    public void addPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person name: ");
        this.person = sc.nextLine();
        System.out.print("Enter site: ");
        this.site = sc.nextLine();
        System.out.print("Enter username: ");
        this.username = sc.nextLine();
        System.out.print("Enter password: ");
        this.password = sc.nextLine();

        Properties properties = new Properties();

        // 💡 This dynamically checks inside your src folder, completely ignoring the C:\JAVA\ working directory!
        try (var is = AddPassword.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                System.out.println("[!] Error: Could not find config.properties inside your src folder.");
                return;
            }
            properties.load(is);
        } catch (Exception e) {
            System.out.println("[!] Configuration file error: " + e.getMessage());
            return;
        }

        // 1. Process your custom text phrase into a mathematically secure 256-bit AES key
        SecretKeySpec secretKey;
        try {
            String rawPhrase = properties.getProperty("app.secret");
            if (rawPhrase == null || rawPhrase.trim().isEmpty()) {
                System.out.println("[!] Error: app.secret is missing from config.properties");
                return;
            }

            // Hash the phrase with SHA-256 to guarantee a perfect 32-byte length key layout
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = sha.digest(rawPhrase.getBytes(StandardCharsets.UTF_8));
            secretKey = new SecretKeySpec(keyBytes, "AES");

        } catch (Exception e) {
            System.out.println("[!] Secret key processing error: " + e.getMessage());
            return;
        }

        String sql = "INSERT INTO Passwords(person, site, username, user_password) VALUES(?, ?, ?, ?)";

        // 2. Added the PreparedStatement inside the resource parentheses for auto-closing protection
        try (Connection conn = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // 3. Encrypt the raw string using your EncryptDecrypt helper utility class
            String encryptedPassword = EncryptDecrypt.encrypt(this.password, secretKey);

            ps.setString(1, person);
            ps.setString(2, site);
            ps.setString(3, username);
            ps.setString(4, encryptedPassword); // Inject the scrambled base64 payload instead!

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\n[✓] Password successfully encrypted and stored!\n");
            }

        } catch (Exception e) {
            System.out.println("[!] Database Error: " + e.getMessage());
        }
    }
}