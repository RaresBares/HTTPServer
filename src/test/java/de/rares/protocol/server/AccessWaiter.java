package de.rares.protocol.server;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AccessWaiter extends Thread {
    ConnectionManager main;
    int port;

    @Override
    public void run() {
        while (true) {
            try {

                Socket s = main.ss.accept();
                DataOutputStream ostream = new DataOutputStream(s.getOutputStream());
                DataInputStream istream = new DataInputStream(s.getInputStream());
                Scanner sc = new Scanner(istream);
                boolean faked = false;
                String[] handshake = new String[3];
                String first = "";
                if ((first = sc.nextLine().replace("\u0007","").trim()).equalsIgnoreCase("Hstart")) {

                } else {
                System.out.println("sdad");
                    faked = true;
                }
                for (int i = 0; i < handshake.length; i++) {
                    if (sc.hasNextLine()) {
                        String msg = sc.nextLine().replace("\u0007","");
                        if (msg != "HSTOP" || msg != "HSTART".replace("\u0007","")) {
                            handshake[i] = msg;
                        } else {//f
                            if (i == 2) {

                            } else {

                                faked = true;
                            }
                        }
                    } else {

                        faked = true;
                    }
                }
                boolean verif = verif(new ArrayList<String>(Arrays.asList(handshake)));
                if (faked) {
                    ostream.writeUTF("403 || Please trigger first the handshake!");
                } else {
                    if (verif) {
                        MessageWaiter ms = new MessageWaiter();
                        ms.t = s;
                        ms.start();
                    }else {
                        ostream.writeUTF("403 || Please trigger first the handshake!");
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean verif(ArrayList<String> hs) {
        System.out.println();
        return true;
    }

}
