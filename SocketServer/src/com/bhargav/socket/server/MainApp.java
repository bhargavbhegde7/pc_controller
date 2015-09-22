package com.bhargav.socket.server;

public class MainApp {
	
	public static void main(String[] args){

		try{
			SocketListener listener = new SocketListener();
			listener.setPort(Integer.parseInt(args[0]));
			listener.startListening();
		}
		catch(Exception e){
			System.out.println("Run time arguments probably not valid : "+e.getMessage());
		}
	}//main ends
}
