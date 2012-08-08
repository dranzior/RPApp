/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Mathieu
 */
public class SharedAccess {
    static private SharedAccess me = null;
    
    private Collection<Player> playerList;
    
    private SharedAccess() {
        playerList = new ArrayList<Player>();
    }
    
    public static SharedAccess getSharedAccess() {
        if (me == null)
            me = new SharedAccess();
        return me;
    }
    
    public void register(Player p) {
        playerList.add(p);
    }
    
    public Player [] getPlayerList() {
        Player [] ret = new Player[playerList.size()];
        playerList.toArray(ret);
        return ret;
    }
}
