import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentData <Student,Books>{

    Student s;
    Books b;

    public StudentData(Student s, Books b) {
        this.s = s;
        this.b = b;
    }
    public void SaveData(){
try{
    HashMap<Student,Books> record= new  HashMap<>();
    record.put(s,b);
    Path file_path=Path.of("StudentData.txt");
    Files.writeString(file_path,record.toString()+"\n", StandardOpenOption.CREATE,StandardOpenOption.APPEND);
    System.out.println("Successfull");
}
catch(Exception e){
    System.out.println(e);
        }







    }
}
