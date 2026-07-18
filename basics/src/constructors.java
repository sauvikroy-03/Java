public class constructors {

    public static void main(String[] args) {
        constructors obj=new constructors();
        constructors obj1=new constructors("Sauvik");
    }
    constructors(){
        System.out.println("initialised!!!!");
    }
    constructors(String name){
        System.out.println("Name is "+name);
    }

}
