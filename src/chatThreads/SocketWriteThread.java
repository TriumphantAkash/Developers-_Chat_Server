package chatThreads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocketWriteThread extends Thread{
	DataOutputStream outToServer;
	BufferedReader messageBufferedReader;
	String message;
	public SocketWriteThread(DataOutputStream outToServer) {
		this.outToServer = outToServer;
	}
	public void run(){
		while(true){
			System.out.print("you: ");
			messageBufferedReader = new BufferedReader( new InputStreamReader(System.in)); 
			try {
				message = messageBufferedReader.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				outToServer.writeBytes(message+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
