import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpResponse {

	private OutputStream output;

	public HttpResponse(Socket socket){
		try{
			this.output = socket.getOutputStream();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void ok(String message){
		try {
			this.output.write(("HTTP/1.0 200 " + message).getBytes(StandardCharsets.UTF_8));
			this.output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void notFound(String message){
		try {
			this.output.write(("HTTP/1.0 404 " + message).getBytes(StandardCharsets.UTF_8));
			this.output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendContext(String contentType, String content){
		try{
			this.output.write("HTTP/1.0 200\n".getBytes(StandardCharsets.UTF_8));
			this.output.write(("Content-Type: " + contentType + "\n").getBytes(StandardCharsets.UTF_8));
			this.output.write(("Content-Length: " + content.length() + "\n").getBytes(StandardCharsets.UTF_8));
			this.output.write("\n".getBytes(StandardCharsets.UTF_8));
			this.output.write(content.getBytes(StandardCharsets.UTF_8));
			this.output.flush();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public void sendFile(String contentType, String fileName){
		try{
			File file = new File("/workspaces/tp-java/tp-2", fileName);
			if(!file.exists()){
				this.notFound("File not Found");
				return;
			}

			FileInputStream inputStream = new FileInputStream(file);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			byte[] buffer = new byte[4096];
			int bytesRead = 0;
		
			do {
				bytesRead = inputStream.read(buffer);
				outputStream.write(buffer, 0, bytesRead);
			}while(bytesRead == 4096);
			inputStream.close();

			this.output.write("HTTP/1.0 200\n".getBytes(StandardCharsets.UTF_8));
			this.output.write(("Content-Type: " + contentType + "\n").getBytes(StandardCharsets.UTF_8));
			this.output.write(("Content-Length: " + outputStream.size() + "\n").getBytes(StandardCharsets.UTF_8));
			this.output.write("\n".getBytes(StandardCharsets.UTF_8));
			this.output.write(outputStream.toByteArray());
			outputStream.close();
			this.output.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
