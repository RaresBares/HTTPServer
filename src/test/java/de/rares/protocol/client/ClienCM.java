package de.rares.protocol.client;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienCM {
    Socket server;

    DataOutput os;
    public ClienCM(String host, int port) throws IOException {
        server = new Socket(host, port);
      OutputStream out;
      os = new DataOutputStream( server.getOutputStream());
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

}
