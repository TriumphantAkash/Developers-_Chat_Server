package chatThreads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocketReadThread extends Thread{
	BufferedReader inFromServer;
	String message;
	public SocketReadThread(BufferedReader inFromServer) {
		this.inFromServer = inFromServer;
	}
	public void run(){
		try {
			while(true){
				message = inFromServer.readLine();
				System.out.println("\nother: "+message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


