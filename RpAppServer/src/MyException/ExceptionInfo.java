/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyException;

/**
 *
 * @author Mathieu
 */
public enum ExceptionInfo {
    //COMMAND
        //ADDPREDEF
            COMMAND_ADDPREDEF_NoRuleType,
            COMMAND_ADDPREDEF_MissingParameter,
            COMMAND_ADDPREDEF_InvalidParameterType,
            COMMAND_ADDPREDEF_InvalidRollType,
        //
        //ROLLANY
            COMMAND_ROLLANY_NoRuleType,
            COMMAND_ROLLANY_MissingParameter,
            COMMAND_ROLLANY_InvalidParameterType,
        //
        //ROLLPREDEF
            COMMAND_ROLLPREDEF_MissingParameter,
            COMMAND_ROLLPREDEF_InvalidParameterType,
        //
        //CONNECTION
            COMMAND_CONNECTION_MissingParameter,
            COMMAND_CONNECTION_DuplicateLogin,
            COMMAND_CONNECTION_InvalidPasswordOrLogin,
        //
    //
    //ROLLER
        ROLLER_InvalidDiceType,
        ROLLER_InvalidDiceNumber,
        //SUCESSCOUNT
            ROLLER_SUCESSCOUNT_InvalidSucessValue,
            ROLLER_SUCESSCOUNT_InvalidAgainValue,
        //
        //THRESHOLD
            ROLLER_THRESHOLD_InvalidThresholdValue,
        //
        //KEEP
            ROLLER_KEEP_InvalidKeepValue,
        //
    //
//SQL
    //DATABASE
        SQL_DATABASE_CannotOpenDatabase,
    //
    //COMMAND
        //INSERT
            SQL_COMMAND_INSERT_DuplicateColumnsValue,
            SQL_COMMAND_INSERT_NoValuesProvided,
        //
    //
//DB
    //TYPEMAP
        DB_TYPEMAP_InvalidType,
}
