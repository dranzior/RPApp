/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller.Rules;

import DiceRoller.DiceResult;
import DiceRoller.Roller;
import MyException.MyException;

/**
 *
 * @author Mathieu
 */
public class LowerRollRule implements DiceRule {

    int diceType;
    int threshold;

    public LowerRollRule(int _diceType, int _threshold) {
        diceType = _diceType;
        threshold = _threshold;
    }

    @Override
    public DiceResult Roll() throws MyException {
        return Roll(0);
    }

    @Override
    public DiceResult Roll(int bonus) throws MyException {
        return Roller.RollLowerRoll(diceType, threshold + bonus);
    }
}
