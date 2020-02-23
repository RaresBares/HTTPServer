package de.rares.protocol.server;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageWaiter extends Thread{
    Socket t;


    @Override
    public void run() {
        boolean state = true;

        try {

            if(t.isConnected()){

                DataInputStream dataInputStream = new DataInputStream(t.getInputStream());
                Scanner sc = new Scanner(dataInputStream);
             while (state){
                 String msg = "";


                 if(sc.hasNextLine()) {
                     msg = sc.nextLine();
                     System.out.println("Geschrieben " + msg);
                     ConnectionManager.wakeUpAll(msg);
                 }

             }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
