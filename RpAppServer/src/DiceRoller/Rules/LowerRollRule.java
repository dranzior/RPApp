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
public class LowerRollRule implements DiceRule {

    int diceType;
    int threshold;

    public LowerRollRule(int _diceType, int _threshold) {
        diceType = _diceType;
        threshold = _threshold;
    }

    @Override
    public DiceResult Roll() throws RollerException {
        return Roll(0);
    }

    @Override
    public DiceResult Roll(int bonus) throws RollerException {
        return Roller.RollLowerRoll(diceType, threshold + bonus);
    }
}
