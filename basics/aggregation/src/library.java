public class library {

    books[]book;
    library(books[]book){
        for(books b:book){
            System.out.println(b.name+" "+b.pages+" pages");  //so this library class is aggregating all books..even if we delete this class ,books can exist independently
        }

    }
}
