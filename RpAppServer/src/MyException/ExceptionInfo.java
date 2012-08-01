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
        //
        //ROLLANY
            COMMAND_ROLLANY_NoRuleType,
            COMMAND_ROLLANY_MissingParameter,
            COMMAND_ROLLANY_InvalidParameterType,
        //
        //ROLLPREDEF
            COMMAND_ROLLPREDEF_MissingParameter,
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
    //DATASET
        SQL_DATASET_InvalidLineNumber,
        SQL_DATASET_InvalidColumnNumber,
        SQL_DATASET_InvalidColumnName,
}
