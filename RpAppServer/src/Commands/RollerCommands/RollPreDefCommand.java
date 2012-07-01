/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.RollerCommands;

import Commands.Command;
import Commands.CommandExceptions;
import rpappserver.Client;

/**
 *
 * @author Mathieu
 */
public class RollPreDefCommand extends Command {

    static public String Name() {
        return "rollpredef";
    }
    
    @Override
    public void Run(String[] param, Client cli) throws CommandExceptions {
        if (param.length != 3)
            throw new CommandExceptions("invalid parameter number");
        try {
            int id = Integer.parseInt(param[1]);
            int bonus = Integer.parseInt(param[2]);
            cli.diceRoller.RollPreDefined(id, bonus);
            String tmp = cli.diceRoller.GetResult();
            cli.Send(tmp);
        } catch (NumberFormatException ex) {
            
        }
        
    }
    
}
