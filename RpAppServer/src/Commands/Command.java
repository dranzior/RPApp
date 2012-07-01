/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import rpappserver.Client;

/**
 *
 * @author Mathieu
 */
public abstract class Command {
    static public String Name() {
        return "Command";
    }
    abstract public void Run(String [] param, Client cli) throws CommandExceptions;
}