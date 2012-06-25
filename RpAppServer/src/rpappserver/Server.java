/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mathieu
 */
public class Server extends Thread {

    ServerSocket socket;
    int port = 44910;
    boolean running = false;
    List clients;
    static Server me;

    private Server() {
        running = false;
        clients = new ArrayList();
    }

    public static Server getServer() {
        if (me == null) {
            me = new Server();
        }
        return me;
    }

    @Override
    public void start() {
        try {
            socket = new ServerSocket();
            socket.bind(new InetSocketAddress(port));
            running = true;
            super.start();
        } catch (IOException ex) {
            System.out.println("Can't open Server");
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                Socket accept = socket.accept();
                if (accept != null) {
                    Client cli = new Client(accept);
                    cli.start();
                    clients.add(cli);
                }
            } catch (IOException ex) {
            }
        }
    }

    public void stopServer() {
        running = false;
        try {
            socket.close();
        } catch (IOException ex) {
        }
        try {
            this.join();
        } catch (InterruptedException ex) {
        }
        for (Object cli : clients) {
            ((Client) cli).stopConnection();
        }
        clients.clear();
    }
}
