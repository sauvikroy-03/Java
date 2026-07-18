import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    AddContact ac=new AddContact();
    ViewContacts vc=new  ViewContacts();
    SearchContact searchContact=new SearchContact();
    DeleteContact deleteContact=new DeleteContact();
    Scanner sc=new Scanner(System.in);

    boolean flag=true;

    while (flag) {

        DisplayOptions displayOptions=new DisplayOptions();
        int choice= sc.nextInt();

        switch (choice) {
            case 1->ac.saveContact();
            case 2->vc.displayContacts();
            case 3->searchContact.getRequestedContact();
            case 4->deleteContact.deleteContact();
            case 5-> {
                System.out.println("Exiting......");
                flag=false;
            }



        }



    }



    }
}