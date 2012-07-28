/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyException;

/**
 *
 * @author Mathieu
 */
public class MyException extends Exception{
    private ExceptionInfo info;
    
    public MyException(ExceptionInfo _info) {
        info = _info;
    }
    
    public String Getinfo() {
        return "TOTO";
    }
    
    public int GetLevel() {
        return 1;
    }
}


