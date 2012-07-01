/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author Mathieu
 */
public class CommandExceptions extends Exception {
    private String info;

    public CommandExceptions(String temp) {
        info = temp;
    }

    public String Getinfo() {
        return info;
    }
}
