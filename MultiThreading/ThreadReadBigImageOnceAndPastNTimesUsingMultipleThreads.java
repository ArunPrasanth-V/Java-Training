import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;

public class Main{
  public static void main(String[] args) throws IOException,InterruptedException{
      File file = new File("sample.jpg");
      FileInputStream in = new FileInputStream(file);
      long size = file.length();
      byte[] temp = new byte[(int)size];
      in.read(temp);
      in.close();

      //calling new Theard
      Thread2 obj=new Thread2(temp);
      obj.start();
      Thread3 obj3=new Thread3(temp);
      obj3.start();
      Thread4 obj4=new Thread4(temp);
      obj4.start();
      Thread5 obj5=new Thread5(temp);
      obj5.start();
  }
}
class Thread2 extends Thread{
    byte[] b;
   private BlockingQueue<byte[]> bq;
   Thread2(BlockingQueue<byte[]> bq){
       this.bq=bq;
   }
   Thread2(byte[] b){
    this.b=b;
}
    public void run(){
        try{
            File file = new File("sample1.txt");
            FileOutputStream fos=new FileOutputStream(file);
            for(byte i:b){
                fos.write(i);
            }
        }
        catch(Exception e){
            System.out.println("Error -" +e);
        }
  }
}

class Thread3 extends Thread{
    byte[] b;
   Thread3(byte[] b){
    this.b=b;
}
    public void run(){
        try{
            File file = new File("sample1.txt");
            FileOutputStream fos=new FileOutputStream(file);
            for(byte i:b){
                fos.write(i);
            }
        }
        catch(Exception e){
            System.out.println("Error -" +e);
        }
  }
}
class Thread4 extends Thread{
    byte[] b;
   Thread4(byte[] b){
    this.b=b;
}
    public void run(){
        try{
            File file = new File("sample1.txt");
            FileOutputStream fos=new FileOutputStream(file);
            for(byte i:b){
                fos.write(i);
            }
        }
        catch(Exception e){
            System.out.println("Error -" +e);
        }
  }
}

class Thread5 extends Thread{
    byte[] b;
   Thread5(byte[] b){
    this.b=b;
}
    public void run(){
        try{
            File file = new File("sample1.txt");
            FileOutputStream fos=new FileOutputStream(file);
            for(byte i:b){
                fos.write(i);
            }
        }
        catch(Exception e){
            System.out.println("Error -" +e);
        }
  }
}
