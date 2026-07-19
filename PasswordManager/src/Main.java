import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DisplayOptions displayOptions=new DisplayOptions();
        ViewAllPasswords viewAllPasswords=new ViewAllPasswords();
        AddPassword addPassword=new AddPassword();
        boolean flag=true;

        while(true){
            displayOptions.displayOptions();
            System.out.println("Enter a choice");
            int choice =sc.nextInt();

            switch(choice){
               case 1->addPassword.addPassword();
               case 2->viewAllPasswords.getAllPasswords();
            }
        }


    }
}