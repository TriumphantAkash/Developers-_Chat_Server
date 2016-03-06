package server;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import chatThreads.*;
public class MobileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//sample comment from devMayank branch
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser;
		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		//while(true){
		//inFromUser = new BufferedReader( new InputStreamReader(System.in));   
		clientSocket = new Socket("10.24.27.194", 6969);
		
		outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
		ClientSocketWriter socketWriteThread = new ClientSocketWriter(outToServer);
		socketWriteThread.start();
		
		inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  
		ClientSocketReader socketReadThread = new ClientSocketReader(inFromServer);
		socketReadThread.start();
		
		//sentence = inFromUser.readLine();
//		if(sentence.equals("exit")){
//			clientSocket.close();
//		}
		//outToServer.writeBytes(sentence + '\n');   
		//modifiedSentence = inFromServer.readLine(); 
		//clientSocket.close();
		//System.out.println(modifiedSentence);
		//}

	}
	
	
	
}

