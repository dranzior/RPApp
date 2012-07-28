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
public class SucessCountRule implements DiceRule {

    int diceType;
    int nbDice;
    int sucess;
    int again;

    public SucessCountRule(int _diceType, int _nbDice, int _sucess, int _again) {
        diceType = _diceType;
        nbDice = _nbDice;
        sucess = _sucess;
        again = _again;
    }

    @Override
    public DiceResult Roll() throws MyException {
        return Roll(0);
    }

    @Override
    public DiceResult Roll(int bonus) throws MyException {
        return Roller.RollSucessCount(diceType, nbDice + bonus, sucess, again);
    }
}
