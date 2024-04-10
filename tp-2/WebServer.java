import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;

public class WebServer {

	public void run(int portNumber){
		try{
			ServerSocket socket = new ServerSocket(portNumber);
			while(true){
				Socket clientSocket = socket.accept();
				RequestProcessor requestProcessor = new RequestProcessor(clientSocket);
				Thread thread = new Thread(requestProcessor);
				thread.start();
			}	
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}