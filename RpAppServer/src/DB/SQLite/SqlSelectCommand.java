/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.SQLite;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Mathieu
 */

public class SqlSelectCommand {
    String table;
    Collection<String> columns;
    Collection<String> clauses;
    
    public SqlSelectCommand(String _table) {
        table = _table;
        columns = new ArrayList();
        clauses = new ArrayList();
    }
    
    public void addColumn(String _column) {
        if (!columns.contains(_column))
            columns.add(_column);
    }
    
    public void addClause(String _column, String op, String value) {
        String tmp = _column + op + value;
        if (!clauses.contains(tmp))
            clauses.add(tmp);
    }
    
    public String createSqlStatement() {
        String ret = "SELECT";
        if (columns.isEmpty())
            ret = ret.concat(" *");
        else {
            Object [] columnsTable = this.columns.toArray();
            ret = ret.concat(" "+(String)columnsTable[0]);
            for (int i=1; i<columnsTable.length; i++)
                ret = ret.concat(", "+(String)columnsTable[i]);
        }
        ret = ret.concat(" FROM");
        ret = ret.concat(" "+table);
        ret = ret.concat(";");
        return ret;
    }
    
    public int getColumnsNumber() {
        return columns.size();
    }
    
    public String getColumnName(int i)
    {
        return (String)columns.toArray()[i];
    }
}
