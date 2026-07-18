import java.sql.*;
import java.util.Scanner;

public class DeleteContact {

    public void deleteContact(){
        String url = "jdbc:postgresql://localhost:5432/contactmanager";
        String username = "postgres";
        String password = "Sauvikroy10.";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        long num =sc.nextLong();
        String query="delete from contacts where number=?";


        try(Connection con= DriverManager.getConnection(url,username,password)){
            PreparedStatement st=con.prepareStatement(query);
            st.setLong(1, num);

            int rowsAffected=st.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Contact Deleted");
            }
            else{
                System.out.println("Contact Not Found");
            }


        }catch(Exception e){
            System.out.println(e.getMessage());
        }



    }
}
