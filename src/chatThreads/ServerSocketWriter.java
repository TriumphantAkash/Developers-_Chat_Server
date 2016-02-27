package chatThreads;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerSocketWriter extends Thread{
	BufferedReader inFromServer;
	String message;
	public ServerSocketWriter() {
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