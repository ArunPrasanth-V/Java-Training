import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("Server Started...");
		ServerSocket server= new ServerSocket(2000);
		// server.accept() this is an block method.here server will wait until the client gets 
		//connected.
		Socket soc=server.accept();
		System.out.println("Client connected..");
		
	}

}
