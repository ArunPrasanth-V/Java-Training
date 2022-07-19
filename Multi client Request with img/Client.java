import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends Thread {
    private byte[] b;
    Client(byte[] b){
        this.b=b;
    }
    public void run(){
        try{
            System.out.println("New Thread Created : "+Thread.currentThread().getName());
            Socket soc=new Socket("localhost",8000);
           DataOutputStream out=new DataOutputStream(soc.getOutputStream());
           out.writeInt(b.length);
           out.write(b);            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
