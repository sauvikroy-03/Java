import java.sql.*;
import java.util.Scanner;

public class SearchContact {

    public void getRequestedContact() {
        String url = "jdbc:postgresql://localhost:5432/contactmanager";
        String username = "postgres";
        String password = "Sauvikroy10.";
        Scanner sc=new  Scanner(System.in);
        System.out.println("Enter mobile number");
        long num=sc.nextLong();
        String sql = "SELECT * FROM contacts where number=?";


        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, num);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                long number = rs.getLong("number");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("-------------CONTACT FOUND-----------------");
                System.out.println(number + " | " + name + " | " + email);
                System.out.println("-------------------------------------------");

            }
            else{
                System.out.println("Contact Not Found");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
