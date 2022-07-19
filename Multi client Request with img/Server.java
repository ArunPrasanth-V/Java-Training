import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static  void main(String args[]){
        try(ServerSocket ss=new ServerSocket(8000);){
            while(true){
                System.out.println("\n\nWaiting for Clients...");
                Socket soc=ss.accept();
                DataInputStream din=new DataInputStream(soc.getInputStream());
                int len=din.readInt();
                if(len>0){
                    byte b[]=new byte[len];
                    din.readFully(b,0,b.length);
                    ServerPojo pojo=new ServerPojo(b);
                }
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
       
    }
}
