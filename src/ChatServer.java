import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String argv[]) throws Exception       {          
		String clientSentence;          
		String capitalizedSentence;          
		ServerSocket welcomeSocket = new ServerSocket(6789);          
		while(true){             
			Socket connectionSocket = welcomeSocket.accept();             
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();             
			System.out.println(clientSentence);
			//System.out.print("server:");
			BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in)); 
			String sentence = inFromUser.readLine();   
			outToClient.writeBytes(sentence + '\n');
			
			//capitalizedSentence = clientSentence.toUpperCase() + '\n';             
			//outToClient.writeBytes(capitalizedSentence);
			}       
		}
}
