
//there is one such thread for each client that connects to the server
//however there is just one writer thread for all the clients currently

package chatThreads;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;


public class ServerSocketReader extends Thread{
	BufferedReader inFromServer;
	String message;
	BlockingQueue<String> bq = null;
	public ServerSocketReader(BufferedReader inFromServer, BlockingQueue<String> queue) {
		this.inFromServer = inFromServer;
		this.bq = queue;
	}
	
	public void run(){
		try {
			while(true){
				message = inFromServer.readLine();	//a new message is arrived
				//now broadcast this message i.e
				//hand this message to ServerSocketWriter thread
				/*
				 * .
				 * (do stuff here)
				 */
				bq.put(message);
				 /* .
				 * ..
				 * */
				/*pass this message to SocketWriterThread, and he will write it to all the 
				connected clinet's output streams
				(may be I can use some Looper or something)*/
				
			
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
}


