import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AddContact {

    private String name;
    private String number;
    private String email;


    public void saveContact(){
        try{
            String url="jdbc:postgresql://localhost:5432/contactmanager" ;
            String username="postgres";
            String password="Sauvikroy10.";
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement st=conn.createStatement();

            Scanner sc=new Scanner(System.in);

            System.out.println("Enter Contact's Name");
            String name=sc.nextLine();
            System.out.println("Enter Contact's Number");
            String number=sc.nextLine();
            System.out.println("Enter Contact's Email");
            String email=sc.nextLine();
            this.name=name;
            this.number=number;
            this.email=email;
            String contactDetails=this.name+" - "+this.number+" - "+this.email;
            String sql="Insert into contacts values(%s,'%s','%s')".formatted(this.number,this.email,this.name);
            st.executeUpdate(sql);
            System.out.println("Successfull");
            conn.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
