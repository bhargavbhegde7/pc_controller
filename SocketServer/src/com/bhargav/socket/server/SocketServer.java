package com.bhargav.socket.server;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
	
	public static boolean moveFlag = false;
	public static int xCoord, yCoord; 
	
	public static void main(String[] args) throws Exception {
		Socket clientSocket = null;
		ServerSocket serverSocket = null;
		try{
		serverSocket = new ServerSocket(4444); 
		System.out.println("server started....");
		clientSocket = serverSocket.accept();
		}catch(Exception e){} //read & display the message
		//BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputS­tream()));
		Scanner in1 = new Scanner(clientSocket.getInputStream());
		String mes; 
		while(true){
			if (in1.hasNext())
				{
					mes=in1.nextLine();
					System.out.println(mes);					
					
					if("left down".equals(mes))
					{
						moveFlag = true;
						startMove(1);
					}
					if("left up".equals(mes))
						moveFlag = false;
					
					if("right down".equals(mes))
					{
						moveFlag = true;
						startMove(2);
					}
					if("right up".equals(mes))
						moveFlag = false;
					
					if("up down".equals(mes))
					{
						moveFlag = true;
						startMove(3);
					}
					if("up up".equals(mes))
						moveFlag = false;
					
					if("down down".equals(mes))
					{
						moveFlag = true;
						startMove(4);
					}
					if("down up".equals(mes))
						moveFlag = false;
					
					if("L down".equals(mes))
						clickMouse("L down");
					if("L up".equals(mes))
						clickMouse("L up");
					
					if("R down".equals(mes))
						clickMouse("R down");
					if("R up".equals(mes))
						clickMouse("R up");
					
					if("M down".equals(mes))
						clickMouse("M down");
					if("M up".equals(mes))
						clickMouse("M up");

				}
			}
		}
	
	public static void clickMouse(String button) throws Exception
	{
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
	
	public static void startMove(int dir)
	{
		switch(dir)
		{
		case 1://left
			move(-1,0);
		break;
		case 2://right
			move(1,0);
		break;
		case 3://up
			move(0,-1);
		break;
		case 4://down
			move(0,1);
		break;
		}
	}
	
	public static void move(int x,int y)
	{
		
		try {
			MotionThread.x = x;
			MotionThread.y = y;
			new Thread(new MotionThread()).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
