public class cylinder {

    String brand;

    lpg l;

    cylinder(String brand,int amount){
        this.brand=brand;
        this.l=new lpg(amount);
        System.out.println("The cylinder is of brand "+brand);
    }
}
