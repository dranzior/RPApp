/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver.Interface;

/**
 *
 * @author Mathieu
 */
// TODO sortir les Println de ce code pour les mettres dans un gestionnaires (Multilingues?)
import Commands.Commands;   // TODO for test only
import java.util.Scanner;
import rpappserver.Network.Server;

public class Console extends Thread {

    Scanner consoleInput = new Scanner(System.in);

    @Override
    public void run() {
        String lecture;
        do {
            System.out.print("Rp App Server > ");
            lecture = consoleInput.nextLine();
            lecture = lecture.toLowerCase();
            String command[] = lecture.split(" ");
            if (command[0].compareToIgnoreCase("exit") == 0) {
                System.out.println("\tclosing server");
            } else if (command[0].compareToIgnoreCase("test") == 0) {
                Commands t = new Commands();
                
                int p = 0;
            } else {
                System.out.println("\tUknown Command");
            }
        } while (lecture.compareTo("exit") != 0);
        Server.getServer().stopServer();
    }
    
}
