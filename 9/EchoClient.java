import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoClient{
	String hostName = args[0];
	int portNumber = Integer.parseInt(args[1]);

	EchoClient(){
		try (
			Socket echoSocket = new Socket(hostName, portNumber);
			PrintWriter out =
				new PrintWriter(echoSocket.getOutputStream(), true);
			BufferedReader in =
				new BufferedReader(
					new InputStreamReader(echoSocket.getInputStream()));
			BufferedReader stdIn =
				new BufferedReader(
					new InputStreamReader(System.in))
		)

		String userInput;
		while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
		}
	}	
	public QuoteServerThread() throws IOException {
		this("QuoteServer");
	}

	public QuoteServerThread(String name) throws IOException {
		super(name);
		socket = new DatagramSocket(4445);

		try {
			in = new BufferedReader(new FileReader("one-liners.txt"));
		}   
		catch (FileNotFoundException e){
			System.err.println("Couldn't open quote file.  Serving time instead.");
		}
	}  
	
	public PacketSend(){
		String dString = null;
		if (in == null)
			dString = new Date().toString();
		else
			dString = getNextQuote();
		buf = dString.getBytes();

		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		packet = new DatagramPacket(buf, buf.length, address, port);
		socket.send(packet);
		byte[] buf = new byte[256];
		InetAddress address = InetAddress.getByName(args[0]);
		DatagramPacket packet = new DatagramPacket(buf, buf.length, 
										address, 4445);
		socket.send(packet);
	}
}