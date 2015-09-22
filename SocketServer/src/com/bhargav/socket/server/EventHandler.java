package com.bhargav.socket.server;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class EventHandler {
	
	public void handle(String event) throws Exception{

		if(Event.W_DN.equals(event)){
			MotionThread.invertFlag();
			moveMouse(-1,0);
		}
		if(Event.W_UP.equals(event))
			MotionThread.invertFlag();		
		if(Event.E_DN.equals(event)){
			MotionThread.invertFlag();
			moveMouse(1,0);
		}
		if(Event.E_UP.equals(event))
			MotionThread.invertFlag();		
		if(Event.N_DN.equals(event)){
			MotionThread.invertFlag();
			moveMouse(0,-1);
		}
		if(Event.N_UP.equals(event))
			MotionThread.invertFlag();		
		if(Event.S_DN.equals(event)){
			MotionThread.invertFlag();
			moveMouse(0,1);
		}
		if(Event.S_UP.equals(event))
			MotionThread.invertFlag();		
		if("L down".equals(event))
			clickMouse("L down");
		if("L up".equals(event))
			clickMouse("L up");		
		if("R down".equals(event))
			clickMouse("R down");
		if("R up".equals(event))
			clickMouse("R up");		
		if("M down".equals(event))
			clickMouse("M down");
		if("M up".equals(event))
			clickMouse("M up");
	}
	
	public static void clickMouse(String button) throws Exception{
		
		Robot robot = new Robot();
		if("L down".equals(button))
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		if("L up".equals(button))
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);		
		if("R down".equals(button))
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		if("R up".equals(button))
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);		
		if("M down".equals(button))
			robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
		if("M up".equals(button))
			robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
	}
	
	public void moveMouse(int x, int y){
		new Thread(new MotionThread(x,y)).start();
	}
}
