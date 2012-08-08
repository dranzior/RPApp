/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import DB.SQLite.DataSet;
import DB.SQLite.SQLiteConnection;
import DB.SQLite.SqlSelectCommand;
import DiceRoller.DiceRoller;

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
        cmdRules.addClause("OwnerId", "=", String.valueOf(id));
        DataSet rules = SQLiteConnection.GetConnection().Select(cmdRules);
        
        SqlSelectCommand cmdParam = new SqlSelectCommand("RuleParam");
        cmdParam.addColumn("ParamId");
        cmdParam.addColumn("ParamValue");
        int [] tblArg = new int[20];
        for (int i=0; i < rules.GetSize(); i++) {
            String ruleId = rules.getData(i, "id");
            cmdParam.addClause("DiceRuleId", "=", ruleId);
            DataSet param = SQLiteConnection.GetConnection().Select(cmdParam);
            
            for (int j=0; j < param.GetSize(); j++) {
                int pos = Integer.parseInt(param.getData(i, "ParamId"));
                int val = Integer.parseInt(param.getData(i, "ParamValue"));
                tblArg[pos] = val;
            }
            
            int ruleType = Integer.parseInt(rules.getData(i, "RuleType"));
            
            switch (ruleType) {
                
            }
            
            cmdParam.clearClauses();
        }
    }
    
}
