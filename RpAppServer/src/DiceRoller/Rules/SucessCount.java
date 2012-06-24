/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller.Rules;

import DiceRoller.DiceResult;
import DiceRoller.Roller;
import MyException.RollerException;

/**
 *
 * @author Mathieu
 */
//TODO a faire la Rule "SucessCount"
public class SucessCount implements DiceRule {
    
    @Override
    public DiceResult Roll() throws RollerException
    {
        return Roll(0);
    }
    @Override
    public DiceResult Roll(int bonus) throws RollerException
    {
        return Roller.RollSucessCount(bonus, bonus, bonus, bonus);
    }
}
