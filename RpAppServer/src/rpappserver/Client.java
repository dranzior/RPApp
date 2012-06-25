/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathieu
 */
public class Client extends Thread {

    Socket socket;
    boolean running = false;
    PrintWriter out = null;
    BufferedReader in = null;

    public Client(Socket _socket) {
        socket = _socket;
    }

    @Override
    public void start() {
        running = true;
        super.start();
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (running) {
            try {
                if (in.ready()) {
                    String tmp = in.readLine();

                }

            } catch (IOException ex) {
            }
        }
    }

    public void stopConnection() {
        running = false;
        try {
            this.join();
        } catch (InterruptedException ex) {
        }
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
        }

    }
}
