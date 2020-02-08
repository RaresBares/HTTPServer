package de.rares.protocol;

import de.rares.protocol.client.ClienCM;
import de.rares.protocol.server.ConnectionManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConnectionManager con = new ConnectionManager(25599);
        ClienCM clienCM = new ClienCM("localhost", 25599);

    }

}
