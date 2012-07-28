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
public class KeepBestRule implements DiceRule {

    int diceType;
    int nbDice;
    int keep;
    int baseBonus;

    public KeepBestRule(int _diceType, int _nbDice, int _keep, int _baseBonus) {
        diceType = _diceType;
        nbDice = _nbDice;
        keep = _keep;
        baseBonus = _baseBonus;
    }

    @Override
    public DiceResult Roll() throws MyException {
        return Roll(0);
    }

    @Override
    public DiceResult Roll(int bonus) throws MyException {
        return Roller.RollKeepBest(diceType, nbDice, keep, baseBonus + bonus);
    }
}
