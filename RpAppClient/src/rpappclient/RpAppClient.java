/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathieu
 */
public class RpAppClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            // TODO code application logic here
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 44910));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            for (int i = 0; i < 5; i++) {
                out.println("Test de Data");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RpAppClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
        }

    }
}
