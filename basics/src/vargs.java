public class vargs {

    public static void main(String[] args) {
    add(8,9,0,7);
}
        static void add(int... numbers)
        {
            for(int number:numbers){  //enhanced for loop
                System.out.println(number);
            }
    }
}
