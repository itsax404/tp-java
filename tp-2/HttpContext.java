import java.io.IOException;
import java.net.Socket;

public class HttpContext {

	private HttpRequest request;
	
	private HttpResponse response;

	private Socket socket;

	public HttpContext(Socket socket){
		this.socket = socket;
		this.request = new HttpRequest(this.socket);
		this.response = new HttpResponse(this.socket);
	}

	public HttpRequest getRequest(){
		return this.request;
	}

	public HttpResponse getResponse() {
		return this.response;
	}

	public void close(){
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
