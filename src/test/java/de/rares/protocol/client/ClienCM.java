package de.rares.protocol.client;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienCM extends Thread {
    Socket server;

    DataOutput os;
    DataInputStream is;
    public ClienCM(String host, int port) throws IOException {
        server = new Socket(host, port);

        os = new DataOutputStream(server.getOutputStream());
        is = new DataInputStream(server.getInputStream());
        start();
        triggerHandshake();
    }

    public void send(String msg) throws IOException {
        os.writeUTF(msg + "\n");
    }


    public void triggerHandshake() throws IOException {

        send("HSTART");
        send("KEY: " + getKey());
        send("GET: response");
        send("HSTOP");

    }

    private String getKey() {
        return "abc";
    }


    @Override
    public void run() {
        while (true){
            try {
                String msg = is.readUTF().trim();
                if(!msg.equals("")){
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
