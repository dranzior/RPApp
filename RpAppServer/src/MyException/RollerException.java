/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyException;

/**
 *
 * @author Mathieu
 */
public class RollerException extends Exception {

    private String info;

    public RollerException(String temp) {
        info = temp;
    }

    public String Getinfo() {
        return info;
    }
}