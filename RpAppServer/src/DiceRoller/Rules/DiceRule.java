/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller.Rules;

import DiceRoller.DiceResult;
import MyException.RollerException;

/**
 *
 * @author Mathieu
 */
public interface DiceRule {
    public DiceResult Roll() throws RollerException;
    public DiceResult Roll(int bonus) throws RollerException;
}
