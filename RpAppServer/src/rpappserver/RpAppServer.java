/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

import rpappserver.Network.Server;
import rpappserver.Interface.Console;
import DB.SQLite.SQLiteConnection;
import MyException.MyException;
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
            try {
                //Créer les modules
                SQLiteConnection.Init("jdbc:sqlite://D:/mathieu/Mes Documents/NetBeansProjects/RPApp/RPApp/RpAppServer/build/RPApp.db");
            } catch (MyException ex) {
                // TODO message d'erreur
                // TODO gestion d'erreur
                return;
            }
            Server.initServer(port);
            Server.getServer().start();
            
                //ouvrir la console
            Console cons = new Console();
            cons.start();
            
        }
    }
}
