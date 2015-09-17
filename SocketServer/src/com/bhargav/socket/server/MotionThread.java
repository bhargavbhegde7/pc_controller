package com.bhargav.socket.server;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class MotionThread implements Runnable{
	
	public static int x, y;
	//public static Robot robot;

	@Override
	public void run() {
		
		try{
		
		Point point = MouseInfo.getPointerInfo().getLocation();
		/*int xCoord = (int) point.getX();
		int yCoord = (int) point.getY();*/
		Robot robot = new Robot();
		
		for(;;)
		{
			if(SocketServer.moveFlag)
			{
				try{
					robot.mouseMove((int)MouseInfo.getPointerInfo().getLocation().getX()+x, (int)MouseInfo.getPointerInfo().getLocation().getY()+y);
				    Thread.sleep(5);				    
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
				break;
		}//infinite for ends
		
		}catch(Exception e)
		{
			
		}
		
	}//run ends

}
