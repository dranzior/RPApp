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
    
    static public final int KeepBest    = 0;
    static public final int LowerRoll   = 1;
    static public final int SimpleRoll  = 2;
    static public final int SucessCount = 3;

    public DiceResult Roll() throws MyException;

    public DiceResult Roll(int bonus) throws MyException;
    
    public void SaveDB(int userId);
    
    public String getName();
}