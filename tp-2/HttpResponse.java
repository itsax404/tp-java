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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void notFound(String message){
		try {
			this.output.write("HTTP/1.0 404 " + message);
			this.output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendContext(String contextType, String content){
		try{
			this.output.write("HTTP/1.0 200\n");
			this.output.write("Content-Type: " + contextType + "\n");
			this.output.write("Content-Length: " + content.length() + "\n");
			this.output.write("\n");
			this.output.write(content);
			this.output.flush();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
