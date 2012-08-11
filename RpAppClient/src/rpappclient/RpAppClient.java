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
            String tmp;
            /*
             * Connect a user
             */
            out.println("connection;DongeonMaster;APassword");
            tmp = in.readLine();
            System.out.println(tmp);

            /*
             * Create new Rules
             * To do only one time as its written in DB
             */
//            out.println("addpredef;simple;simple;10;2;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("addpredef;keep;keep;10;5;2;5");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("addpredef;sucess;sucess;10;5;8;10");
//            tmp = in.readLine();
//            System.out.println(tmp);
//            out.println("addpredef;lower;lower;100;42");
//            tmp = in.readLine();
//            System.out.println(tmp);
            
            /*
             * Test previously created rules
             * To do only if the "Create new Rules" is uncommented
             * or if it alredy run on the DB
             */
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
             * Test Specific Roll (Can be done as Standalone)
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
