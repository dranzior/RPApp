/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

import java.util.HashMap;
import java.util.Map;

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
        int port = 44910;
        Map<String, Boolean> param = new HashMap();
        param.put("port",false);
        for (String command : args) {
            if (command.compareToIgnoreCase("-G") == 0) {
                graph = true;
            } else if (command.compareToIgnoreCase("-C") == 0) {
                graph = false;
            } else if (command.compareToIgnoreCase("-P") == 0) {
                param.put("port",true);
            } else if (param.get("port")) {
                port = Integer.parseInt(command);
                param.put("port",false);
            }
            else
            {
                for (String b:param.keySet()) {
                    param.put(b, false);
                }
            }
        }
        if (graph) {
            System.out.println("InterfaceGraphique");
        } else {
            Console cons = new Console();
            cons.start();
            Server.initServer(port);
            Server.getServer().start();
        }
    }
}
