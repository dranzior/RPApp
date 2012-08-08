/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.SQLite;

import MyException.ExceptionInfo;
import MyException.MyException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mathieu
 */
public class DataSet {
    Map<String, Integer> columns = new HashMap();
    String[][] data;
    int nbColumns;
    int nbLines;
    
    public DataSet(ResultSet rs, SqlSelectCommand cmd) throws SQLException {
        nbColumns = cmd.getColumnsNumber();
        nbLines = 0;
        
        Collection<String[]> dataTmp = new ArrayList();
        
        for (int i = 0; i < nbColumns; i++)
            columns.put(cmd.getColumnName(i), i);
        
        while (rs.next()) {
            String [] strTmp = new String[nbColumns];
            for (int i = 0; i < nbColumns; i++)
                strTmp[i] = rs.getString(i+1);
            dataTmp.add(strTmp);
            nbLines++;
        }
        data = new String [nbLines][nbColumns];
        dataTmp.toArray(data);
    }
    
    public String getData(int _line, int _column) {
        return data[_line][_column];
    }
    
    public String getData(int _line, String _column) {
        int tmp = columns.get(_column);
        return getData(_line, tmp);
    }
    
    public int GetSize() {
        return nbLines;
    }
}
