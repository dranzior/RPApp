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
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 44910));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tmp = null;
            /*
             * Test de Connection
             */
            out.println("connection;DongeonMaster;APassword");
            tmp = in.readLine();
            System.out.println(tmp);

            /*
             * Test de Rule
             */
//            out.println("addpredef;simple;10;2;5");
//            out.println("addpredef;keep;10;5;2;5");
//            out.println("addpredef;sucess;10;5;8;10");
//            out.println("addpredef;lower;100;42");
//            out.println("rollpredef;0;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("rollpredef;1;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("rollpredef;2;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("rollpredef;3;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
            
            /*
             * Test de Roll simple
             */
//            out.println("rollany;simple;10;2;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("rollany;keep;10;5;2;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("rollany;lower;100;42");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("rollany;sucess;10;5;8;10");
//            tmp = in.readLine();
//            System.out.println(tmp);
            

            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
        }

    }
}
