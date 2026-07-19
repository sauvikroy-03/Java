import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class DeletePassword {


    public  void deletePassword(){
        Scanner sc=new Scanner(System.in);
        ViewAllPasswords v=new ViewAllPasswords();


        Properties properties=new Properties();
        try (var is = DeletePassword.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                System.out.println("[!] Error: Could not find config.properties inside your src folder.");
                return;
            }
            properties.load(is);
        } catch (Exception e) {
            System.out.println("[!] Configuration file error: " + e.getMessage());
            return;
        }
        v.getAllPasswords();
        System.out.println("Enter person's name : ");
        String name=sc.nextLine();
        System.out.println("Enter Site/App : ");
        String  site=sc.nextLine();
        System.out.println("Enter Username: ");
        String username=sc.nextLine();

        try(Connection conn= DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),
                properties.getProperty("password"))){
            PreparedStatement ps=conn.prepareStatement("delete from passwords where person=? and site=? and username=?");
            ps.setString(1,name);
            ps.setString(2,site);
            ps.setString(3,username);

            int affected_row=ps.executeUpdate();
            if(affected_row>0){
                System.out.println("Deletion Completed");
                v.getAllPasswords();
            }


        }
        catch(Exception e){
            System.out.println("[!] Error: " + e.getMessage());
        }

    }
}
