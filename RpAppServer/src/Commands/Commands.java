/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;


import Commands.RollerCommands.AddPreDefCommand;
import Commands.RollerCommands.RollAny;
import Commands.RollerCommands.RollPreDefCommand;
import java.util.HashMap;
import java.util.Map;
import rpappserver.Client;
/**
 *
 * @author Mathieu
 */
public class Commands {

    private Map<String, Command> commands = new HashMap();

    public Commands() {
        commands.put(AddPreDefCommand.Name(), new AddPreDefCommand());
        commands.put(RollPreDefCommand.Name(), new RollPreDefCommand());
        commands.put(RollAny.Name(), new RollAny());
    }

    public void Run(Client cli, String[] command) {
        try {
            commands.get(command[0]).Run(command, cli);
        } catch (CommandExceptions ex) {
            // TODO Log
        } catch (NullPointerException ex) {
            System.out.println("wtf?");
        }
    }
}
