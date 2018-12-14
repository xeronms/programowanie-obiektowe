import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger

public class EchoServer{
	
	int portNumber = Integer.parseInt(args[0]);
	EchoServer(){
		try ( 
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out =
				new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream()));
		) 
		try (
		PrintWriter out =
			new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(
			new InputStreamReader(clientSocket.getInputStream()));
	) {
		String inputLine, outputLine;
		
		// Initiate conversation with client
		KnockKnockProtocol kkp = new KnockKnockProtocol();
		outputLine = kkp.processInput(null);
		out.println(outputLine);

		while ((inputLine = in.readLine()) != null) {
			outputLine = kkp.processInput(inputLine);
			out.println(outputLine);
			if (outputLine.equals("Bye."))
				break;
		}
		
		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);

		try (
			Socket kkSocket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(kkSocket.getInputStream()));
		)
		while ((fromServer = in.readLine()) != null) {
			System.out.println("Server: " + fromServer);
			if (fromServer.equals("Bye."))
				break;

			fromUser = stdIn.readLine();
			if (fromUser != null) {
				System.out.println("Client: " + fromUser);
				out.println(fromUser);
			}
		}

		while (true) {
			
			ExecutorService executorService = Executors.newFixedThreadPool(10);
		}
	}
	class StartController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

	
    private void lWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                Parent root=  FXMLLoader.load(Clients.class.getResource("LoginPanel.fxml"));
                Scene newScene = new Scene(root);
                Stage newStage = new Stage();
                newStage.setScene(newScene);
                newStage.show(); 
    }

    private void sWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                Parent root=  FXMLLoader.load(DataBase.class.getResource("Registration.fxml"));
                Scene newScene = new Scene(root);
                Stage newStage = new Stage();
                newStage.setScene(newScene);
                newStage.show(); 
    }
    
}
}