package chatThreads;

import java.io.BufferedReader;
import java.io.IOException;

import models.Client;
import server.MainServer;

//reads from the server and display messages on user's screen
public class ClientSocketReader extends Thread{
	BufferedReader inFromServer;
	String message;
	public ClientSocketReader(BufferedReader inFromServer) {
		this.inFromServer = inFromServer;
	}
	public void run(){
		try {
			System.out.println("client reader thread is up and running");
			while(true){
				Thread.sleep(2000);
				message = inFromServer.readLine();	//a new message is arrived
				System.out.println("got this message from main server: "+message+"\n");
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
