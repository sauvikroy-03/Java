import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>ar=new ArrayList<>();

        ar.add(1);
        ar.add(2);
        ar.add(5);
        System.out.println(ar);
        ar.remove(1);
        System.out.println(ar);
        System.out.println("Size is"+ar.size());
        ar.set(0,20);
        System.out.println(ar);
    }
}