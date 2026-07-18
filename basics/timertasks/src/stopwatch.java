import java.util.Timer;
import java.util.TimerTask;

public class stopwatch {
    static int minutes=00;
    static int seconds=00;
    static int milliseconds=00;
    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){

            @Override
            public void run(){

                if (seconds==17){
                    System.out.println("Heyyyyy");
                }
                milliseconds+=01;
                if(milliseconds==100){
                    seconds+=01;
                    milliseconds=00;
                }
                if (seconds==60){
                    minutes+=01;
                    seconds=00;
                }
                System.out.printf("\r%02d:%02d:%02d",minutes,seconds,milliseconds);
            }
        };

        timer.schedule(task,0,10);

    }






}
