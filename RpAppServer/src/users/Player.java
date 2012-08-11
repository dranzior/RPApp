/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import DB.SQLite.DataSet;
import DB.SQLite.SQLiteConnection;
import DB.SQLite.SqlSelectCommand;
import DiceRoller.DiceRoller;
import DiceRoller.Rules.*;

/**
 *
 * @author Mathieu
 */
public class Player {
    int id; //Database Id of the Player
    int userType;   //Access of the user (0: player, 1: DM, 2: SuperAdmin
    public DiceRoller diceRoller = new DiceRoller();
    
    public Player(int _id, int _userType) {
        id = _id;
        userType = _userType;
        LoadPreDefinedDices();
    }
    
    private void LoadPreDefinedDices () {
        SqlSelectCommand cmdRules = new SqlSelectCommand("DiceRule");
        cmdRules.addColumn("id");
        cmdRules.addColumn("RuleType");
        cmdRules.addColumn("Name");
        cmdRules.addClause("OwnerId", "=", String.valueOf(id));
        DataSet rules = SQLiteConnection.GetConnection().Select(cmdRules);
        
        SqlSelectCommand cmdParam = new SqlSelectCommand("RuleParam");
        cmdParam.addColumn("ParamId");
        cmdParam.addColumn("ParamValue");
        int [] tblArg = new int[20];
        for (int i=0; i < rules.GetSize(); i++) {
            String ruleId = rules.getData(i, "id");
            String name = rules.getData(i, "Name");
            cmdParam.addClause("DiceRuleId", "=", ruleId);
            DataSet param = SQLiteConnection.GetConnection().Select(cmdParam);
            
            for (int j=0; j < param.GetSize(); j++) {
                int pos = Integer.parseInt(param.getData(j, "ParamId"));
                int val = Integer.parseInt(param.getData(j, "ParamValue"));
                tblArg[pos] = val;
            }
            
            int ruleType = Integer.parseInt(rules.getData(i, "RuleType"));
            
            switch (ruleType) {
                case DiceRule.KeepBest:
                    diceRoller.AddRule(new KeepBestRule(name, tblArg[1], tblArg[2], tblArg[3], tblArg[4]));
                    break;
                case DiceRule.LowerRoll:
                    diceRoller.AddRule(new LowerRollRule(name, tblArg[1], tblArg[2]));
                    break;
                case DiceRule.SimpleRoll:
                    diceRoller.AddRule(new SimpleRollRule(name, tblArg[1], tblArg[2], tblArg[3]));
                    break;
                case DiceRule.SucessCount:
                    diceRoller.AddRule(new SucessCountRule(name, tblArg[1], tblArg[2], tblArg[3], tblArg[4]));
                    break;
            }
            cmdParam.clearClauses();
        }
    }
    
    public void AddRule(DiceRule rule) {
        rule.SaveDB(id);
        diceRoller.AddRule(rule);
    }
    
}
