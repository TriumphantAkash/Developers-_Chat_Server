
//there is one such thread for each client that connects to the server
//however there is just one writer thread for all the clients currently

package chatThreads;
import models.Client;
import server.MainServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;


public class ServerSocketReader extends Thread{
	BufferedReader inFromServer;
	Client client;
	String message;
	BlockingQueue<String> bq = null;
	public ServerSocketReader(Client client, BlockingQueue<String> queue) {
		this.client = client;
		this.inFromServer = client.getInputStream();
		this.bq = queue;
	}
	
	public void run(){
		try {
			while(true){
				message = inFromServer.readLine();	//a new message is arrived
				if(message == null){
					//remove this client from our list and stop this thread
					MainServer.clientList.remove(client);
					return;
				}
				if(message.equals("exiting")){
					//remove this client from our list and stop this thread
					MainServer.clientList.remove(client);
					return;
				}
				//now broadcast this message i.e
				//hand this message to ServerSocketWriter thread
				/*
				 * .
				 * (do stuff here)
				 */
				if((bq!=null) && (message != null)){
					bq.put(message);
				}
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


