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
            switch (command) {
                case "-G":
                    break;
                case "-C":
                    graph = false;
                    break;
                default:
                    break;
            }
        }
        if (graph) {
            System.out.println("InterfaceGraphique");
        } else {
            Console cons = new Console();
            cons.start();
        }
    }
}
