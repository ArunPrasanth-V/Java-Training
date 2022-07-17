import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Clien started..");
		Socket soc=new Socket("localhost",2000);
	}

}
