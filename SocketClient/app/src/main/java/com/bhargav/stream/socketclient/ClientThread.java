package com.bhargav.stream.socketclient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by bhargav on 9/12/2015.
 */
public class ClientThread implements Runnable {

    private static final int SERVERPORT = 4444;
    private static final String SERVER_IP = "192.168.137.1";
    //private static final String SERVER_IP = "192.168.137.194";

    @Override
    public void run() {

        try {
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

            MainActivity.socket = new Socket(serverAddr, SERVERPORT);

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}