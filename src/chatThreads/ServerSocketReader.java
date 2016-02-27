
//there is one such thread for each client that connects to the server
//however there is just one writer thread for all the clients currently

package chatThreads;
import java.io.BufferedReader;
import java.io.IOException;

import models.Client;

public class ServerSocketReader extends Thread{
	BufferedReader inFromServer;
	String message;
	public ServerSocketReader(BufferedReader inFromServer) {
		this.inFromServer = inFromServer;
	}
	public void run(){
		try {
			while(true){
				message = inFromServer.readLine();	//a new message is arrived
				//now broadcast this message i.e
				//send this message to all active SocketWriteThreads
				//read from standard input
				
				/*pass this message to SocketriterThread, and he will write it to all the 
				connected clinet's output streams
				*/
				
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


