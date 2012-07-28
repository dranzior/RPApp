/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller;

import DiceRoller.Rules.DiceRule;
import MyException.MyException;
import java.util.ArrayList;

/**
 *
 * @author Mathieu
 */
public class DiceRoller {

    private ArrayList<DiceResult> result = new ArrayList();
    private ArrayList<DiceRule> preDefined = new ArrayList();

    public void RollPreDefined(int id) {
        RollPreDefined(id, 0);
    }

    public void RollPreDefined(int id, int bonus) {
        try {
            result.add(preDefined.get(id).Roll(bonus));
        } catch (MyException ex) {
            // TODO Log
        }
    }

    public String GetResult() {
        return GetResult(result.size() - 1);
    }

    public String GetResult(int pos) {
        if (pos < 0 || pos >= result.size()) {
            return null;
        }
        DiceResult tmp = result.get(pos);
        return tmp.getTime() + ";" + tmp.getRoll() + ";" + tmp.getresult();
    }

    public void AddRule(DiceRule rule) {
        preDefined.add(rule);
    }

    public void RollSimpleRoll(int diceType, int nbDice, int bonus) {
        try {
            result.add(Roller.RollSimpleRoll(diceType, nbDice, bonus));
        } catch (MyException ex) {
            // TODO Log
        }
    }

    public void RollSucessCount(int diceType, int nbDice, int sucess, int again) {
        try {
            result.add(Roller.RollSucessCount(diceType, nbDice, sucess, again));
        } catch (MyException ex) {
            // TODO Log
        }
    }

    public void RollLowerRoll(int diceType, int threshold) {
        try {
            result.add(Roller.RollLowerRoll(diceType, threshold));
        } catch (MyException ex) {
            // TODO Log
        }
    }

    public void RollKeepBest(int diceType, int nbDice, int keep, int bonus) {
        try {
            result.add(Roller.RollKeepBest(diceType, nbDice, keep, bonus));
        } catch (MyException ex) {
            // TODO Log
        }
    }

    public void LoadInfoFromBd(int userId) {
        result.clear();
        preDefined.clear();
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void SaveInfoToBd() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
