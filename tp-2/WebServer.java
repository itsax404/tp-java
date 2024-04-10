import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class WebServer {
	private void readRequest(Socket socket){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = "";
			StringBuilder builder = new StringBuilder();
			while((response = reader.readLine()) != null){
				builder.append(response);
			}
			System.out.println(builder.toString());
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	private void sendResponse(Socket socket){
		try{
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getInputStream()));
			writer.write("HTTP/1.0 200 OK\r\n");
			writer.flush();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void run(int portNumber){
		Socket socket = new ServerSocket(portNumber);
		while(true){
			Socket clientSocket = socket.accept();
			this.readRequest(clientSocket);
			this.sendResponse(clientSocket);

			clientSocket.close();
		}

	}
}