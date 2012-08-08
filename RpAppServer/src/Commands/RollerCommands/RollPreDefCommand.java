/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.RollerCommands;

import Commands.Command;
import MyException.ExceptionInfo;
import MyException.MyException;
import rpappserver.Network.Client;

/**
 *
 * @author Mathieu
 */
public class RollPreDefCommand extends Command {

    static public String Name() {
        return "rollpredef";
    }
    
    @Override
    public String Run(String[] param, Client cli) throws MyException {
        if (param.length != 3)
            throw new MyException(ExceptionInfo.COMMAND_ROLLPREDEF_MissingParameter);
        try {
            int id = Integer.parseInt(param[1]);
            int bonus = Integer.parseInt(param[2]);
            cli.player.diceRoller.RollPreDefined(id, bonus);
        } catch (NumberFormatException ex) {
            throw new MyException(ExceptionInfo.COMMAND_ROLLPREDEF_InvalidParameterType);
        }
        return "result;"+cli.player.diceRoller.GetResult();
        
    }
    
}
