/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DbTypeMap;

import MyException.ExceptionInfo;
import MyException.MyException;

/**
 *
 * @author Mathieu
 */
public class DbTypeMap {
    //RuleType
    static public int getRuleType(RuleType type) throws MyException {
        switch (type) {
            case SIMPLE_ROLL:
                return 0;
            case KEEP_BEST:
                return 1;
            case LOWER_ROLL:
                return 2;
            case SUCESS_COUNT:
                return 3;
            default:
                throw new MyException(ExceptionInfo.DB_TYPEMAP_InvalidType);
        }
    }
    static public RuleType getRuleType(int type) throws MyException {
        switch (type) {
            case 0:
                return RuleType.SIMPLE_ROLL;
            case 1:
                return RuleType.KEEP_BEST;
            case 2:
                return RuleType.LOWER_ROLL;
            case 3:
                return RuleType.SUCESS_COUNT;
            default:
                throw new MyException(ExceptionInfo.DB_TYPEMAP_InvalidType);
        }
    }
}
