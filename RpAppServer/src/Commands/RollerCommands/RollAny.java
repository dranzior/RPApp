/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.RollerCommands;

import Commands.Command;
import Commands.CommandExceptions;
import DiceRoller.Rules.KeepBestRule;
import DiceRoller.Rules.LowerRollRule;
import DiceRoller.Rules.SimpleRollRule;
import DiceRoller.Rules.SucessCountRule;
import rpappserver.Client;

/**
 *
 * @author Mathieu
 */
public class RollAny extends Command{
    static public String Name() {
        return "rollany";
    }
    
    @Override
    public void Run(String[] param, Client cli) throws CommandExceptions {
        if (param.length < 2)
            throw new CommandExceptions("no rule type");
        if (param[1].compareToIgnoreCase("simple") == 0) {
            if (param.length != 5)
                throw new CommandExceptions("invalid parameter number");
            try {
                int diceType = Integer.parseInt(param[2]);
                int nbDice = Integer.parseInt(param[3]);
                int baseBonus = Integer.parseInt(param[4]);
                cli.diceRoller.RollSimpleRoll(diceType, nbDice, baseBonus);
            } catch (NumberFormatException ex) {
                throw new CommandExceptions("invalide parameter type");
            }
            
        }
        if (param[1].compareToIgnoreCase("sucess") == 0) {
            if (param.length != 6)
                throw new CommandExceptions("invalid parameter number");
            try {
                int diceType = Integer.parseInt(param[2]);
                int nbDice = Integer.parseInt(param[3]);
                int sucess = Integer.parseInt(param[4]);
                int again = Integer.parseInt(param[5]);
                
                cli.diceRoller.RollSucessCount(diceType, nbDice, sucess, again);
            } catch (NumberFormatException ex) {
                throw new CommandExceptions("invalide parameter type");
            }
        }
        if (param[1].compareToIgnoreCase("lower") == 0) {
            if (param.length != 4)
                throw new CommandExceptions("invalid parameter number");
            try {
                int diceType = Integer.parseInt(param[2]);
                int threshold = Integer.parseInt(param[3]);
                cli.diceRoller.RollLowerRoll(diceType, threshold);
            } catch (NumberFormatException ex) {
                throw new CommandExceptions("invalide parameter type");
            }
        }
        if (param[1].compareToIgnoreCase("keep") == 0) {
            if (param.length != 6)
                throw new CommandExceptions("invalid parameter number");
            try {
                int diceType = Integer.parseInt(param[2]);
                int nbDice = Integer.parseInt(param[3]);
                int nbKeep = Integer.parseInt(param[4]);
                int baseBonus = Integer.parseInt(param[5]);
                cli.diceRoller.RollKeepBest(diceType, nbDice, nbKeep, baseBonus);
            } catch (NumberFormatException ex) {
                throw new CommandExceptions("invalide parameter type");
            }
        }
        cli.Send(cli.diceRoller.GetResult());
    }
    
}
