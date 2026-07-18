//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        car c1=new car();
        car c2=new car(){ //anonymous class
            @Override
            void  run(){
                System.out.println("car2 is running...burrr");
            }

//            void x(){
//                System.out.println("A new feature for this car");   //see this doesnt work because x is not defined in car class
//            }
        };

        c1.run();
        c2.run();
//        c2.x();
    }
}