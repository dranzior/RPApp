/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mathieu
 */
public class Server extends Thread {

    ServerSocketChannel socket;
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
            socket = ServerSocketChannel.open();
            socket.configureBlocking(false);
            socket.socket().bind(new InetSocketAddress(port));
            running = true;
            super.start();
        } catch (IOException ex) {
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                SocketChannel accept = socket.accept();
                if (accept != null) {
                    Client cli = new Client(accept);
                    cli.start();
                    clients.add(cli);
                }
            } catch (IOException ex) {
            }
        }
        for (Object cli : clients) {
            ((Client) cli).stopConnection();
        }
        clients.clear();
    }

    public void stopServer() {
        running = false;
    }
}
