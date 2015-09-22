package com.bhargav.socket.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ListenerThread implements Runnable{
	
	private int port;
	private Socket clientSocket = null;
	private ServerSocket serverSocket = null;
	
	public ListenerThread(int port){
		this.port = port;
	}

	@Override
	public void run(){
		Scanner scanner = null;
		EventHandler eventHandler = new EventHandler();
		try{
			serverSocket = new ServerSocket(port); 
			System.out.println("server started....");
			clientSocket = serverSocket.accept();
			scanner = new Scanner(clientSocket.getInputStream());
			String msg;
			while(true){
				if(scanner.hasNext()){
					msg=scanner.nextLine();
					System.out.println(msg);
				 	//new EventHandler().handle(msg);
					eventHandler.handle(msg);
				}
			}//while loop ends
			//scanner.close();
		}
		catch (Exception e){
			System.out.println(" Error while initiating the socket : "+e.getMessage());
		}		
		scanner.close();		
	}//run ends
}
