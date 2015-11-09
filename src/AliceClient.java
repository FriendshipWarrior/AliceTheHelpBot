
/**
* @author Dustin Hurst
* CS 3250
* Assignemtn 4
* Client side of the program that will speak to the Alice server bot and ask her questions about UVU and get a reply from her
**/

import java.io.*;
import java.net.*;

public class AliceClient {

	private static final String EXIT_CODE = "Alice: @@@@SERVER_EXIT";
	
	public static void main(String[] args) throws IOException {

		// check proper arguments are entered
		if (args.length != 1) {
			System.out.println("Usage: java AliceClient <ip address>");
			System.exit(1);
		}
		String serverHostname = new String(args[0]);

		int port = 9000;

		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		// Connect to server
		try {
			socket = new Socket(serverHostname, port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		// Interaction with Alice begins here
		System.out.println("You are now connected to Alice. How can I help?");
		System.out.print("You: ");
		while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);

			String incoming = in.readLine();

			if (incoming.equals(EXIT_CODE)) {
				System.out.printf("Allice: Goodbye! \n");
				break;
			}
			
			System.out.println(incoming);

			System.out.print("You: ");
		}

		out.close();
		in.close();
		stdIn.close();
		socket.close();
	}
}
