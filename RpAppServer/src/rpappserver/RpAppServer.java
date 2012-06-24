/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

/**
 *
 * @author Mathieu
 */
public class RpAppServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean graph = true;
        for (String command : args) {
            if (command.compareToIgnoreCase("-G") == 0)
                graph = true;
            else if(command.compareToIgnoreCase("-C") == 0)
                graph = false;
            else;
        }
        if (graph) {
            System.out.println("InterfaceGraphique");
        } else {
            Console cons = new Console();
            cons.start();
        }
    }
}
