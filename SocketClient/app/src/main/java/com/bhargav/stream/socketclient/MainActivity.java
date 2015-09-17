package com.bhargav.stream.socketclient;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends Activity {

    public static Socket socket;
    public static boolean L_CLICKED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new ClientThread()).start();
        Button button = new Button(getApplicationContext());

        button = (Button)findViewById(R.id.goLeft);
        movePtr(button, "left");

        button = (Button)findViewById(R.id.goRight);
        movePtr(button,"right");

        button = (Button)findViewById(R.id.goUp);
        movePtr(button,"up");

        button = (Button)findViewById(R.id.goDown);
        movePtr(button,"down");

        button = (Button)findViewById(R.id.lClick);
        movePtr(button,"L");

        button = (Button)findViewById(R.id.rClick);
        movePtr(button,"R");

        button = (Button)findViewById(R.id.mClick);
        movePtr(button,"M");
    }

    public void movePtr(Button button, final String mouseButton)
    {
        button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        sendEvent(mouseButton + " down");
                        break;
                    case MotionEvent.ACTION_UP:
                        sendEvent(mouseButton+" up");
                        break;
                }
                return true;
            }
        });
    }

    public void sendEvent(String event)
    {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true);
            out.println(event);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
