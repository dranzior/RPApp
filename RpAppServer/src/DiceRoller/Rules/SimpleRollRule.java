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
public class SimpleRollRule implements DiceRule {

    private int diceType;
    private int nbDice;
    private int baseBonus;

    public SimpleRollRule(int _diceType, int _nbDice, int _baseBonus) {
        diceType = _diceType;
        nbDice = _nbDice;
        baseBonus = _baseBonus;
    }

    @Override
    public DiceResult Roll() throws MyException {
        return Roll(0);
    }

    @Override
    public DiceResult Roll(int bonus) throws MyException {
        return Roller.RollSimpleRoll(diceType, nbDice, baseBonus + bonus);
    }
}
