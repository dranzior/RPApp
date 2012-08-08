/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import MyException.MyException;
import rpappserver.Network.Client;

/**
 *
 * @author Mathieu
 */
public abstract class Command {
    static public String Name() {
        return "Command";
    }
    abstract public String Run(String [] param, Client cli) throws MyException;
}