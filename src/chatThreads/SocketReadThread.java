package chatThreads;
import server.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import models.Client;

public class SocketReadThread extends Thread{
	BufferedReader inFromServer;
	String message;
	public SocketReadThread(BufferedReader inFromServer) {
		this.inFromServer = inFromServer;
	}
	public void run(){
		try {
			while(true){
				message = inFromServer.readLine();	//a new message is arrived
				//now broadcast this message i.e
				//send this message to all active SocketWriteThreads
				for (Client curr_client : MainServer.clientList) {
					curr_client.getOutputStream().writeBytes(message);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


