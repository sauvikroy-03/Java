import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClassModel model=new ClassModel();
        StudentModel studentModel=new StudentModel();
        Path filePath=Path.of("StudentData.txt");
        Scanner sc=new  Scanner(System.in);
        System.out.println("Enter Student Id");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student Name");
        String name= sc.nextLine();
        System.out.println("Enter Student Class");
        int sclass= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student address");
        String address= sc.nextLine();
        List<String> books=model.getBooks(sclass);
        studentModel.setId(id);
        studentModel.setName(name);
        studentModel.setS_class(sclass);
        studentModel.setAddress(address);
        StudentData<StudentModel,List<String>>studentData=new StudentData<>(studentModel,books);
        studentData.SaveData();




    }
}