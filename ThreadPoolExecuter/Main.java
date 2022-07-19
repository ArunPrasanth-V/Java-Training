import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main{
    public static void main(String args[]){
        ExecutorService exe= Executors.newFixedThreadPool(2);

        Runnable thread1=new Message(1);
        exe.execute(thread1);

        Runnable thread2=new Message(2);
        exe.execute(thread2);

        Runnable thread3=new Message(3);
        exe.execute(thread3);

        Runnable thread4=new Message(4);
        exe.execute(thread4);
        exe.shutdown();
        System.out.println("All process submitted!!");
    }
}
