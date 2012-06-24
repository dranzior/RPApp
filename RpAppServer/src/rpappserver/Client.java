/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 *
 * @author Mathieu
 */
public class Client extends Thread {

    SocketChannel socket;
    boolean running;

    public Client(SocketChannel _socket) {
        socket = _socket;
    }

    public void Start() {
        try {
            socket.configureBlocking(false);
            socket.socket().setKeepAlive(true);
            super.start();
        } catch (IOException ex) {
        }
    }

    @Override
    public void run() {
        while (running) {
        }
    }

    public void stopConnection() {
        running = false;
    }
}
