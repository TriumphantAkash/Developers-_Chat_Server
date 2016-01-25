import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//sample comment from devMayank branch
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser;
		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		while(true){
		inFromUser = new BufferedReader( new InputStreamReader(System.in));   
		clientSocket = new Socket("localhost", 6789);   
		outToServer = new DataOutputStream(clientSocket.getOutputStream());   
		inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));   
		sentence = inFromUser.readLine();
		if(sentence.equals("exit")){
			clientSocket.close();
		}
		outToServer.writeBytes(sentence + '\n');   
		modifiedSentence = inFromServer.readLine();   
		System.out.println(modifiedSentence);
		}

	}

}
