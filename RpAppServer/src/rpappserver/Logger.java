/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

/**
 *
 * @author Mathieu
 */
public class Logger {
    /*
     * Singleton
     */
    private static Logger logger;
    private Logger(){}
    public static Logger getLogger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }    
}
