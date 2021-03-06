package server;
import models.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

import chatThreads.ServerSocketReader;
import chatThreads.ServerSocketWriter;

//main server which keeps track of all the client
//THere is no direct communication between the clients
//Main server is the mediator and keeps track of all input and output channel associated with each client

//there is one reader thread corresponding to each client connects to the server
//there is just one Writer thead that takes care of all writing whenever any message from any
//client is received

public class MainServer {
	//an ArrayList of Clients
	public static ArrayList<Client> clientList;
	private static ServerSocket welcomeSocket;
	private static Client curr_client;
	private static BlockingQueue<String> queue = null;
	
	public static void main(String argv[]) throws IOException {
		try {
			welcomeSocket = new ServerSocket(6970);
		    clientList = new ArrayList<Client>();
		    queue = new ArrayBlockingQueue<String>(1000);
		    //for now let's assume there will be a single socket writer thread that will
		    //write to all the connected clinet's output streams
		    //Consumer of BlockingQueue
		    ServerSocketWriter serverWriteThread = new ServerSocketWriter(queue);
		    serverWriteThread.start();
		    
			while(true){
				System.out.println("[Developers' chat] server is up and running baby...");
				Socket connectionSocket = welcomeSocket.accept();
				
				//control comes here whenever a new client is connected to the server
				connectionSocket.getLocalAddress();
				connectionSocket.getLocalPort();
				
				//create a new client object and input this into client list
				curr_client = new Client();
				curr_client.setId(clientList.size()+1);
				
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				curr_client.setInputStream(inFromClient);
				
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				curr_client.setOutputStream(outToClient);
				
				clientList.add(curr_client);
				
				handleClient(curr_client);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			welcomeSocket.close();
		}
	}
	
	//will create a separate Socket Reader thread for each client that connects to the server
	static void handleClient(Client client){
		
		ServerSocketReader socketReadThread = new ServerSocketReader(client, queue);
		socketReadThread.start();

	}
}
