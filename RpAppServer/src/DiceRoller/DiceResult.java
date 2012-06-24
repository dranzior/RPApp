/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mathieu
 */
public class DiceResult {

    private String time;
    private String roll;
    private String result;

    public DiceResult(String _roll, String _result) {
        SimpleDateFormat df = new SimpleDateFormat("hh/mm/ss");
        time = df.format(new Date());
        roll = _roll;
        result = _result;
    }

    public String getTime() {
        return time;
    }

    public String getRoll() {
        return roll;
    }

    public String getresult() {
        return result;
    }
}
