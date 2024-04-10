import java.io.File;
import java.net.Socket;

public class RequestProcessor {
	
	private HttpContext context;
	
	public RequestProcessor(Socket socket){
		this.context = new HttpContext(socket);
		this.process();
	}

	private void process(){
		String url = this.context.getRequest().getUrl();
		File fileAsked = new File("./public"+url);
		if(url.equals("\\")){
			this.context.getResponse().sendFile("text/html", "/public/index.html");	
		}else if(fileAsked.exists()){
			if(url.endsWith("png")){
				this.context.getResponse().sendFile("image/png", "/public"+url);
			}else if(url.endsWith("mp4")){
				this.context.getResponse().sendFile("video/mp4", "/public"+url);
			}else if(url.endsWith("css")){
				this.context.getResponse().sendFile("text/css", "/public"+url);
			}else if(url.endsWith("html")){
				this.context.getResponse().sendFile("text/html", "/public"+url);
			}else{
				this.context.getResponse().notFound("File not found!");
			}
		}else{
			this.context.getResponse().notFound("Not Found");
		}
		this.context.close();
	}
}
