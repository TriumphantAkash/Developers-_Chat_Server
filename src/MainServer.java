import models.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import chatThreads.SocketReadThread;
import chatThreads.SocketWriteThread;

//main server which keeps track of all the client
//THere is no direct communication between the clients
//Main server is the mediator and keeps track of all input and output channel associated with each client

public class MainServer {
	//an ArrayList of Clients
	private static ArrayList<Client> clientList;
	private static ServerSocket welcomeSocket;
	
	public static void main(String argv[]) throws IOException {
		try {
			welcomeSocket = new ServerSocket(6969);
		          
			while(true){             
				Socket connectionSocket = welcomeSocket.accept();             
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				
				SocketReadThread socketReadThread = new SocketReadThread(inFromClient);
				socketReadThread.start();
				
				SocketWriteThread socketWriteThread = new SocketWriteThread(outToClient);
				socketWriteThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			welcomeSocket.close();
		}
	}
}
