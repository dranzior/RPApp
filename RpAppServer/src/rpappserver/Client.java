/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

import Commands.Commands;
import DiceRoller.DiceRoller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Mathieu
 */
public class Client extends Thread {
    private Socket socket;
    private boolean running = false;
    private Commands cmds;
    public DiceRoller diceRoller = new DiceRoller();
    private BufferedReader in = null;
    private PrintWriter out = null;

    public Client(Socket _socket) {
        socket = _socket;
        cmds = new Commands();
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            // TODO Log
        }
    }

    @Override
    public void start() {
        running = true;
        super.start();
    }

    @Override
    public void run() {        
        String [] cmd;
        while (running) {
            cmd = Parse(socket);
            if (cmd != null) {
                cmds.Run(this, cmd);
            }                
        }
    }

    public void stopConnection() {
        running = false;
        try {
            this.join();
        } catch (InterruptedException ex) {
            // TODO Log
        }
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            // TODO Log
        }
    }

    public String[] Parse(Socket so) {
        String[] ret;
        ArrayList<Character> str = new ArrayList();
        try {
            String cmd;
            if (in.ready()) {
                cmd = in.readLine();
                ret = cmd.split(";");
                return ret;
            }
        } catch (IOException ex) {
            // TODO log
        }
        return null;
    }

    public void Send(String data) {
        out.println(data);
    }
}