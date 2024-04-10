import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest{

	private String method;

	private String url;

	public HttpRequest(Socket socket){
		this.readClientRequest(socket);
	}

	private void readClientRequest(Socket socket){
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String firstLine = input.readLine();
			this.method = firstLine.split(" ")[0];
			this.url = firstLine.split(" ")[1];
			input.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public String getUrl(){
		return this.url;
	}

	public String getMethod() {
		return this.method;
	}

}