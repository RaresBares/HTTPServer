package de.rares.protocol.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ConnectionManager {
    protected  ServerSocket ss = null;
    protected static   ArrayList<Messanger> messangers = new ArrayList();
    protected AccessWaiter waiter;
    public ConnectionManager(int port) throws IOException {
        ss = new ServerSocket(port);
        waiter = new AccessWaiter();
        waiter.port = port;
        waiter.main = this;
        waiter.start();

    }
    public static void wakeUpAll(String msg){}


}
