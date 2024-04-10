import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class WebServer {

	public void run(int portNumber){
		try{
			ServerSocket socket = new ServerSocket(portNumber);
			while(true){
				Socket clientSocket = socket.accept();
				RequestProcessor requestProcessor = new RequestProcessor(clientSocket);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}