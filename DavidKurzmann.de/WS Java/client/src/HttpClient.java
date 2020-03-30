import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;

public class HttpClient{
	public HttpClient() throws Exception{
		final Socket so = new Socket("localhost",8081);
		final OutputStream os = so.getOutputStream();
		final String req = "GET http://localhost:8080/MavenWebApp/ HTTP/1.1\r\n";
		os.write(req.getBytes());
		String header = "Host: localhost\r\n\r\n";
		os.write(header.getBytes());
		final InputStream in = so.getInputStream();
		final byte[] b = new byte[1];
		while((in.read(b)) != -1) {
			System.out.write(b,0,1);
		}
		os.close();
		in.close();
		so.close();
	}
	public static void main(String[] args) throws Exception {
		new HttpClient();
		}



	}


