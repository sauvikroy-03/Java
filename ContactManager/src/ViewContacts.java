import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewContacts {

    public void displayContacts() {
        String url = "jdbc:postgresql://localhost:5432/contactmanager";
        String username = "postgres";
        String password = "Sauvikroy10.";

        String sql = "SELECT * FROM contacts";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n--- Saved Contacts ---");

            // 2. Loop through the rows one by one
            while (rs.next()) {
                // 3. Extract data by column names using correct types
                long number = rs.getLong("number"); // Matches BIGINT
                String name = rs.getString("name");   // Matches VARCHAR
                String email = rs.getString("email"); // Matches VARCHAR

                // 4. Print it out cleanly
                System.out.println("Name: " + name + " | Phone: " + number + " | Email: " + email);
            }
            System.out.println("----------------------\n");

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}