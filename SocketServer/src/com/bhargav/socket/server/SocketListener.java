package com.bhargav.socket.server;

public class SocketListener {
	
	private Integer port = null;

	public void setPort(int port){
		this.port = port;
	}
	
	public void startListening(){
		try{
			new Thread(new ListenerThread(port)).start();
		}
		catch(Exception e){
			System.out.println(" looks like the port is not set : "+e.getMessage());
		}
	}//startListener ends	
}
