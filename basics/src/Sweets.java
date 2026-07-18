public class Sweets {

    String name;
    int quantity;

    Sweets(String name,int quantity) {
        this.name = name;
        this.quantity=quantity;
    }

    void eat(){
        System.out.println("Eating"+quantity+" "+name);
    }
}
