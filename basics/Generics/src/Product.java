public class Product<Item,Price> {

    Item i;
    Price p;


    void setItems(Item i,Price p){
        this.i=i;
        this.p=p;

    }

    public class ProductDetails{
        public final Item item;
        public final Price price;

        public ProductDetails(Item i,Price p){
            this.item=i;
            this.price=p;
        }
    }

    public ProductDetails getItem(){
        return new ProductDetails(i,p);
    }
    }