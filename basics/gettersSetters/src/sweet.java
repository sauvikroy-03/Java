public class sweet {

    private int amount=9000; //this variable is private means it cannot be accessed outside of this class normally without getters or setters

    int getAmount(){       //This is getter method
        return amount;
    }
    int setAmount(int amt){   //this is setter method
      this.amount=amt;
      return  amount;
    }
}
