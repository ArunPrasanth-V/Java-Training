import java.io.FileReader;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
public class Main {
  public static void main(String args[]){
    try{
        File file=new File("sample.jpg");
        FileInputStream fis=new FileInputStream(file);  
        //having query
        // once the data in the buffer get read whether it get refilled automatically

        BufferedInputStream br=new BufferedInputStream(fis,20);
        // here i will sent only 1000 byte to the server.
        //because for every 20 byte i'm creating new thread.
        int count =1;
       while(br.available()!=-1 && count<1000){
        byte[] res=new byte[20];
        br.read(res);
        Client client=new Client(res);
        client.start();
        Thread.sleep(1000);
        count++;
       }
    }
    catch( Exception e){
        System.out.println(e);
    }
   
  }
}
