import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(9,"io");
        System.out.println(map.toString());

        if (map.containsKey(9)){
            System.out.println(map.get(9));
        }
        



    }
}