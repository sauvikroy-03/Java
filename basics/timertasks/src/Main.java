import java.util.Timer;
import java.util.TimerTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){

            //to stop

            int count =3;
            @Override
            public void run(){
                System.out.println("Hello");
                count--;
                if(count==0){
                    timer.cancel();
                }


            }
        };
        timer.schedule(task,3000,1000);
    }
}