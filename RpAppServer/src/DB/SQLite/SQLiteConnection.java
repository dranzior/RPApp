/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.SQLite;

import MyException.ExceptionInfo;
import MyException.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mathieu
 */
public class SQLiteConnection{

    static SQLiteConnection me;
    Connection conn;
    
    private SQLiteConnection(String connectionString) throws MyException {    
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(connectionString);
            conn.setAutoCommit(false);
        } catch (Exception ex) {
            throw new MyException(ExceptionInfo.SQL_DATABASE_CannotOpenDatabase);
        }
    }
    
    public static void Init(String connectionString) throws MyException {
        if (me == null)
            me = new SQLiteConnection(connectionString);
    }
    
    public static SQLiteConnection GetConnection() {
        return me;
    }
    
    public synchronized void Insert(SqlInsertCommand command) {
        try {
            String tmp = command.createSqlStatement();
            conn.createStatement().executeUpdate(tmp);
            conn.commit();
        } catch (MyException ex) {
            
        } catch (SQLException ex) {
            String t = ex.getMessage();
            int i = 10;
        }
        
        
    }

    static public SqlSelectCommand GetlastId(String table)
    {
        SqlSelectCommand cmd = new SqlSelectCommand("sqlite_sequence");
        cmd.addColumn("seq");
        cmd.addClause("name", "=", "\""+table+"\"");
        return cmd;
    }
    
    public synchronized DataSet Select(SqlSelectCommand command) {
        try {
            String tmp = command.createSqlStatement();
            ResultSet rs = conn.createStatement().executeQuery(command.createSqlStatement());
            DataSet ds = new DataSet(rs, command);
            return ds;
        } catch (SQLException ex) {
            //TODO Log
            String tmp = ex.getMessage();
            int i=0;
        }
        return null;
    }
    
    public synchronized void Commit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
