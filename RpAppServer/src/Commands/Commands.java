/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;


import Commands.Connection.ConnectionCommand;
import Commands.RollerCommands.AddPreDefCommand;
import Commands.RollerCommands.RollAny;
import Commands.RollerCommands.RollPreDefCommand;
import MyException.MyException;
import java.util.HashMap;
import java.util.Map;
import rpappserver.Network.Client;
/**
 *
 * @author Mathieu
 */
public class Commands {

    private Map<String, Command> commands = new HashMap();
    
    public Commands() {
        commands.put(ConnectionCommand.Name(), new ConnectionCommand());
        //Add default command here
    }
    
    public void AddAdminCommands() {
        
    }
    
    public void AddDmCommands() {
        
    }
    
    public void AddUserCommands() {
        
    }
    
    public void AddRollerCommands() {
        commands.put(AddPreDefCommand.Name(), new AddPreDefCommand());
        commands.put(RollPreDefCommand.Name(), new RollPreDefCommand());
        commands.put(RollAny.Name(), new RollAny());
    }
    
    public void Run(Client cli, String[] command) {
        try {
            String tmp = commands.get(command[0]).Run(command, cli);
            cli.Send(tmp);
        } catch (MyException ex) {
            cli.Send("error;"+ex.Getinfo());
            // TODO Log
        } catch (NullPointerException ex) {
            // TODO Log
            //Command inexistant ou innacessible à l'utilisateur
        }
    }
}
