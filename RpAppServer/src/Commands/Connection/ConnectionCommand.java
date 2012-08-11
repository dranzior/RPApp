/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Connection;

import Commands.Command;
import DB.SQLite.DataSet;
import DB.SQLite.SQLiteConnection;
import DB.SQLite.SqlSelectCommand;
import MyException.ExceptionInfo;
import MyException.MyException;
import rpappserver.Network.Client;

/**
 *
 * @author Mathieu
 */
public class ConnectionCommand extends Command {
    static public String Name() {
        return "connection";
    }
    @Override
    public String Run(String[] param, Client cli) throws MyException {
        if (param.length < 3)
            throw new MyException(ExceptionInfo.COMMAND_CONNECTION_MissingParameter);
            
        if (cli.player != null)
            throw new MyException(ExceptionInfo.COMMAND_CONNECTION_DuplicateLogin);
            
        SqlSelectCommand cmd = new SqlSelectCommand("Users");
        cmd.addColumn("Id");
        cmd.addColumn("Password");
        cmd.addColumn("UserType");
        cmd.addClause("name", "=", "\""+param[1]+"\"");
        DataSet data = SQLiteConnection.GetConnection().Select(cmd);
        if (data.getData(0, "Password").compareTo(param[2]) == 0) {
            int id = Integer.parseInt(data.getData(0, "Id"));
            int userType = Integer.parseInt(data.getData(0, "UserType"));
            cli.InitPlayer(id, userType);
            switch (userType) {
                case 2:
                    cli.cmds.AddAdminCommands();
                case 1:
                    cli.cmds.AddDmCommands();
                case 0:
                    cli.cmds.AddUserCommands();
            }
            return "connection;sucess";
        } else {
            throw new MyException(ExceptionInfo.COMMAND_CONNECTION_InvalidPasswordOrLogin);
        }
            
        
    }
    
}
