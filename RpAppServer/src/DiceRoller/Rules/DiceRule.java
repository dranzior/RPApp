/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller.Rules;

import DiceRoller.DiceResult;
import MyException.MyException;

/**
 *
 * @author Mathieu
 */
public interface DiceRule {

    public DiceResult Roll() throws MyException;

    public DiceResult Roll(int bonus) throws MyException;
}
