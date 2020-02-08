package de.rares.protocol.server;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class AccessWaiter extends Thread {
    ConnectionManager main;
    int port;

    @Override
    public void run() {
        try {
            while (true) {

                Socket t = main.ss.accept();
                DataInputStream dataInputStream = new DataInputStream(t.getInputStream());
                boolean hsv;

                if (dataInputStream.readUTF().trim().equalsIgnoreCase("HSTART")) {

                    ArrayList<String> hs = new ArrayList<>();
                    String msg = "";
                    while ((msg = dataInputStream.readUTF()).trim() != "") {
                        if (msg.contentEquals("HSTOP")) {
                            msg = "";

                        } else {
                            System.out.println(msg.trim());
                            hs.add(msg.trim());


                        }
                    }



                    hsv = verif(hs);
                } else {
                    new DataOutputStream(t.getOutputStream()).writeUTF("ERROR 403 | please trigger the Handshake!");
                    dataInputStream.readUTF();
                    dataInputStream.readUTF();
                    dataInputStream.readUTF();


                }
                if (true) {

                    MessageWaiter ms = new MessageWaiter();
                    ms.t = t;
                    ms.start();


                } else {

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean verif(ArrayList<String> hs) {
        return true;
    }

}
