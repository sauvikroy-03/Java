//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        books b1=new books("book1",90);
        books b2= new books("book2",120);
        books b3=new books("book3",20);
        books[]book={b1,b2,b3};

        library l=new library(book);
    }
}