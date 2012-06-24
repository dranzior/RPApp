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
public class SimpleRollRule implements DiceRule {
    private int diceType;
    private int nbDice;
    private int baseBonus;
    
    public SimpleRollRule(int _diceType, int _nbDice, int _baseBonus){
        diceType    = _diceType;
        nbDice      = _nbDice;
        baseBonus   = _baseBonus;
    }
    
    @Override
    public DiceResult Roll() throws RollerException{
        return Roll(0);
    }
    
    @Override
    public DiceResult Roll(int bonus) throws RollerException{
        return Roller.RollSimpleRoll(diceType, nbDice, baseBonus+bonus);
    }
}
