package cisproject.OnlineTextBasedRPG;

import java.util.Scanner;

public class Main {
	public static void main(String[] str) throws Exception {
		System.out.println("1) Server \n2) Client");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();

		switch (i) {
		case 1:
			Server.server();
			break;
		case 2:
			Client.client();
			break;
		default:
			break;
		}
		s.close();
	}
}
