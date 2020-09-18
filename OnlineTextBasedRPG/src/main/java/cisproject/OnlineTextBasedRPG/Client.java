package cisproject.OnlineTextBasedRPG;

import java.net.Socket;

public class Client {
	static final String ip = "localhost";
	static final int port = 6666;
	public static void client() throws Exception {
		Socket s = new Socket(ip, port);
		s.close();
	}
}
