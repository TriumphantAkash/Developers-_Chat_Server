package chatThreads;


import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import models.Client;
import server.MainServer;

public class ServerSocketWriter extends Thread{
	//BufferedReader inFromServer;
	String message;
	DataOutputStream tempOutputStream;
	BlockingQueue<String> queue;
	public ServerSocketWriter(BlockingQueue<String> bq) {
		this.queue = bq;
	}
	
	public void run(){
		try {
			while(true){
				//1) receive this mesasge from any of the SocketReaderThread
				//(May be I can use some looper or something to receive 
				/*
				 * 
				 * do stuff here*/
				String message = queue.take();
				
				//for now I am gonna go ahead and just print it
				System.out.println("received this message on server: "+message);
				
				//later I am gonna write this message to all client's outputStreams (MainServer.clientList.getOutputStream())
                //handle the data
				/* 
				 * */
				System.out.println("the size of current client llist is: "+MainServer.clientList.size());
				//a message here from any of the ServerSocketReader thread)
				//2) write this message to outputstreams of all connected clients
				for(Client client: MainServer.clientList){
					client.getOutputStream().writeBytes(message+"\n");
					Thread.sleep(500);
				}
				
				
				/*pass this message to SocketriterThread, and he will write it to all the 
				connected clinet's output streams
				*/
				
			
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}