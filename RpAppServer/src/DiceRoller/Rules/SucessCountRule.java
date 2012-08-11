/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller.Rules;

import DB.SQLite.DataSet;
import DB.SQLite.SQLiteConnection;
import DB.SQLite.SqlInsertCommand;
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
    String name;

    public SucessCountRule(String _name, int _diceType, int _nbDice, int _sucess, int _again) {
        diceType = _diceType;
        nbDice = _nbDice;
        sucess = _sucess;
        again = _again;
        name = _name;
    }

    @Override
    public DiceResult Roll() throws MyException {
        return Roll(0);
    }

    @Override
    public DiceResult Roll(int bonus) throws MyException {
        return Roller.RollSucessCount(diceType, nbDice + bonus, sucess, again);
    }
    
    @Override
    public void SaveDB(int userId) {
        try {
            SqlInsertCommand insertRuleCmd = new SqlInsertCommand("DiceRule");
            insertRuleCmd.AddValue("OwnerId", String.valueOf(userId));
            insertRuleCmd.AddValue("RuleType", String.valueOf(SucessCount));
            insertRuleCmd.AddValue("Name", "\""+name+"\"");
            SQLiteConnection.GetConnection().Insert(insertRuleCmd);
            
            DataSet ds = SQLiteConnection.GetConnection().Select(SQLiteConnection.GetlastId("DiceRule"));
            String newIndex = ds.getData(0, 0);
            
            SqlInsertCommand insertParamCmd = new SqlInsertCommand("RuleParam");
            insertParamCmd.AddValue("DiceRuleId", newIndex);
            insertParamCmd.AddValue("ParamId", "1");
            insertParamCmd.AddValue("ParamValue", String.valueOf(diceType));
            SQLiteConnection.GetConnection().Insert(insertParamCmd);
            
            insertParamCmd.clearValue();
            insertParamCmd.AddValue("DiceRuleId", newIndex);
            insertParamCmd.AddValue("ParamId", "2");
            insertParamCmd.AddValue("ParamValue", String.valueOf(nbDice));
            SQLiteConnection.GetConnection().Insert(insertParamCmd);
            
            insertParamCmd.clearValue();
            insertParamCmd.AddValue("DiceRuleId", newIndex);
            insertParamCmd.AddValue("ParamId", "3");
            insertParamCmd.AddValue("ParamValue", String.valueOf(sucess));
            SQLiteConnection.GetConnection().Insert(insertParamCmd);
            
            insertParamCmd.clearValue();
            insertParamCmd.AddValue("DiceRuleId", newIndex);
            insertParamCmd.AddValue("ParamId", "4");
            insertParamCmd.AddValue("ParamValue", String.valueOf(again));
            SQLiteConnection.GetConnection().Insert(insertParamCmd);
            
        } catch (MyException ex) {
            
        }
    }
    
    @Override
    public String getName() {
        return name;
    }
}
