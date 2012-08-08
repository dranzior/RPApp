/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.RollerCommands;

import Commands.Command;
import DiceRoller.Rules.KeepBestRule;
import DiceRoller.Rules.LowerRollRule;
import DiceRoller.Rules.SimpleRollRule;
import DiceRoller.Rules.SucessCountRule;
import MyException.ExceptionInfo;
import MyException.MyException;
import rpappserver.Network.Client;

/**
 *
 * @author Mathieu
 */
public class AddPreDefCommand extends Command {
    static public String Name() {
        return "addpredef";
    }
    @Override
    public String Run(String [] param, Client cli) throws MyException {
        if (param.length < 2)
            throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_NoRuleType);
        if (param[1].compareToIgnoreCase("simple") == 0) {
            if (param.length != 5)
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_MissingParameter);
            try {
                int diceType = Integer.parseInt(param[2]);
                int nbDice = Integer.parseInt(param[3]);
                int baseBonus = Integer.parseInt(param[4]);
                cli.player.diceRoller.AddRule(new SimpleRollRule(diceType, nbDice, baseBonus));
            } catch (NumberFormatException ex) {
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_InvalidParameterType);
            }
            
        }
        else if (param[1].compareToIgnoreCase("sucess") == 0) {
            if (param.length != 6)
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_MissingParameter);
            try {
                int diceType = Integer.parseInt(param[2]);
                int nbDice = Integer.parseInt(param[3]);
                int sucess = Integer.parseInt(param[4]);
                int again = Integer.parseInt(param[5]);
                
                cli.player.diceRoller.AddRule(new SucessCountRule(diceType, nbDice, sucess, again));
            } catch (NumberFormatException ex) {
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_InvalidParameterType);
            }
        }
        else if (param[1].compareToIgnoreCase("lower") == 0) {
            if (param.length != 4)
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_MissingParameter);
            try {
                int diceType = Integer.parseInt(param[2]);
                int threshold = Integer.parseInt(param[3]);
                cli.player.diceRoller.AddRule(new LowerRollRule(diceType, threshold));
            } catch (NumberFormatException ex) {
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_InvalidParameterType);
            }
        }
        else if (param[1].compareToIgnoreCase("keep") == 0) {
            if (param.length != 6)
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_MissingParameter);
            try {
                int diceType = Integer.parseInt(param[2]);
                int nbDice = Integer.parseInt(param[3]);
                int nbKeep = Integer.parseInt(param[4]);
                int baseBonus = Integer.parseInt(param[5]);
                cli.player.diceRoller.AddRule(new KeepBestRule(diceType, nbDice, nbKeep, baseBonus));
            } catch (NumberFormatException ex) {
                throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_InvalidParameterType);
            }
        }
        else {
            throw new MyException(ExceptionInfo.COMMAND_ADDPREDEF_InvalidRollType);
        }
        return "AddPreDef;Sucess";
    }
}
