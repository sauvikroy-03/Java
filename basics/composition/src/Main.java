//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        cylinder c1=new cylinder("Indian oil",20);
        cylinder c2=new cylinder("Bharat Petroliun",12);
        cylinder c3=new cylinder("Indane",15);

        cylinder[]collection={c1,c2,c3};


        for (cylinder c:collection){

            System.out.println(c.brand+" ->"+c.l.amount);

        }



    }
}