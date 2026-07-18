import java.util.Arrays;

public class TwoD_Arrays {
    public static void main(String[] args) {
        int[]a={2,6,9};
        int[]b={7,8,9};
        int[]c={12,13,14};

        int[][] mixed={a,b,c};
        int[]res=new int[3];
        Arrays.fill(res,1);
        System.out.println(mixed.length);
       for(int i=0;i<mixed[0].length;i++){
           for(int k=0;k<mixed.length;k++){
               res[i]*=mixed[k][i];
           }
       }
       System.out.println(Arrays.toString(res));

    }

}
