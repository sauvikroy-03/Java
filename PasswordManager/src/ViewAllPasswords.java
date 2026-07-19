import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ViewAllPasswords {

    public void getAllPasswords(){


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

        try(Connection con = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));){

            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from passwords");
            System.out.println("-----------Password List-----------------");
            System.out.println("id | person | site | username | password | date_modified");
            System.out.println("---+--------+------+----------+----------+--------------");

            while (rs.next()) {

                String id=rs.getString("id");
                String person=rs.getString("person");
                String site=rs.getString("site");
                String username=rs.getString("username");
                String password=rs.getString("user_password");
                String date=rs.getString("date_modified");

                String result= id+" | "+person+" | "+site+" | "+username+" | "+password+" | "+date;
                System.out.println(result);



            }
            System.out.println("-----------------------------------------");



        }catch(Exception e){

        }
    }
}
