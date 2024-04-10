import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {

	private BufferedWriter output;

	public HttpResponse(Socket socket){
		try{
			this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void ok(String message){
		try {
			this.output.write("HTTP/1.0 200 " + message);
			this.output.flush();
			this.output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void notFound(String message){
		try {
			this.output.write("HTTP/1.0 404 " + message);
			this.output.flush();
			this.output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
