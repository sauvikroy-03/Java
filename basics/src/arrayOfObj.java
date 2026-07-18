public class arrayOfObj {


    public static void main(String[] args) {
        Sweets a = new Sweets("Rasmalai", 2);
        Sweets b = new Sweets("Gulabjamun", 4);
        Sweets c = new Sweets("Petha", 5);


        Sweets[] sweet = {a, b, c};

        for (Sweets s : sweet) {
            System.out.println(s.name+" "+s.quantity);
            s.eat();
        }

    }
}
