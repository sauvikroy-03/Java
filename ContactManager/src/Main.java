import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    AddContact ac=new AddContact();
    Scanner sc=new Scanner(System.in);
    DisplayOptions displayOptions=new DisplayOptions();

    int choice= sc.nextInt();

    switch (choice) {
        case 1->ac.saveContact();


    }


    }
}