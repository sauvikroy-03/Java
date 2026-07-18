import java.util.Arrays;
import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] a=new int[10];

        for(int i=0;i<10;i++){
            System.out.println("Enter number for "+i);
            a[i]=sc.nextInt();

        }

        System.out.println(Arrays.toString(a));
    }
}
