package com.bhargav.socket.server;

import java.awt.MouseInfo;
import java.awt.Robot;

public class MotionThread implements Runnable{
	
	private static boolean moveFlag = false;
	private int x,y;
	
	public MotionThread(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static void invertFlag(){
		moveFlag = !moveFlag;
	}

	@Override
	public void run() {
		try{
			Robot robot = new Robot();
			for(;;){
				if(moveFlag){
					robot.mouseMove((int)MouseInfo.getPointerInfo().getLocation().getX()+x, (int)MouseInfo.getPointerInfo().getLocation().getY()+y);
					Thread.sleep(5);				    
				}
				else
					break;
			}//infinite for ends
		}catch(Exception e){

		}
	}

}
