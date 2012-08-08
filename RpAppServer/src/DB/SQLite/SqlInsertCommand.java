/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.SQLite;

import MyException.ExceptionInfo;
import MyException.MyException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mathieu
 */
public class SqlInsertCommand {
    String table;
    Map<String, String> columns = new HashMap();
    
    public SqlInsertCommand(String _table) {
        table = _table;
    }
    
    public void AddValue(String column, String value) throws MyException {
        if (columns.containsKey(column))
            throw new MyException(ExceptionInfo.SQL_COMMAND_INSERT_DuplicateColumnsValue);
        columns.put(column, value);
    }
    
    public String createSqlStatement() throws MyException {
        if (columns.isEmpty())
            throw new MyException(ExceptionInfo.SQL_COMMAND_INSERT_NoValuesProvided);
        String [] key = new String [columns.size()];
        columns.keySet().toArray(key);
        String [] val = new String [columns.size()];
        columns.values().toArray(val);
        
        String ret = "INSERT INTO";
        ret = ret.concat(" "+table);
        ret = ret.concat(" (");
        ret = ret.concat((String)key[0]);
        for (int i = 1; i < key.length; i++)
            ret = ret.concat(", "+key[i]);
        ret = ret.concat(")");
        ret = ret.concat(" VALUES");
        ret = ret.concat(" (");
        ret = ret.concat((String)key[0]);
        for (int i = 1; i < val.length; i++)
            ret = ret.concat(", "+val[i]);
        ret = ret.concat(" );");
        return ret;
    }
}
