import java.net.Socket;

public class RequestProcessor {
	
	private HttpContext context;
	
	public RequestProcessor(Socket socket){
		this.context = new HttpContext(socket);
		this.process();
	}

	private void process(){
		String url = this.context.getRequest().getUrl();
		if(url.equals("\\")){
			this.context.getResponse().ok("OK");
		}else{
			this.context.getResponse().notFound("Not Found");
		}
		this.context.close();
	}
}
