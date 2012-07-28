/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller;

import MyException.ExceptionInfo;
import MyException.MyException;
import java.util.Arrays;

/**
 *
 * @author Mathieu
 */
public class Roller {

    static private int RandomRoll(int diceType) {
        //Random rnd = new Random();
        double result = (int) ((Math.random() * (diceType)) + 1);
        return (int) result;
    }

    static public DiceResult RollSimpleRoll(int diceType, int nbDice, int bonus) throws MyException {
        if (diceType < 1) {
            throw new MyException(ExceptionInfo.ROLLER_InvalidDiceType);
        }
        if (nbDice < 1) {
            throw new MyException(ExceptionInfo.ROLLER_InvalidDiceNumber);
        }

        String dice = String.valueOf(nbDice) + "d" + String.valueOf(diceType) + "+" + String.valueOf(bonus);
        int total = 0;
        String result = new String();
        for (int i = 1; i <= nbDice; i++) {
            int temp = RandomRoll(diceType);
            if (i != 1) {
                result = result + ",";
            }
            result = result + String.valueOf(temp);
            total = total + temp;
        }
        total = total + bonus;
        result = result + " + " + String.valueOf(bonus) + " = " + String.valueOf(total);
        return new DiceResult(dice, result);
    }

    static public DiceResult RollSucessCount(int diceType, int nbDice, int sucess, int again) throws MyException {
        if (diceType < 1) {
            throw new MyException(ExceptionInfo.ROLLER_InvalidDiceType);
        }
        if (nbDice < 1) {
            throw new MyException(ExceptionInfo.ROLLER_InvalidDiceNumber);
        }
        if (sucess < 1 || sucess > diceType) {
            throw new MyException(ExceptionInfo.ROLLER_SUCESSCOUNT_InvalidSucessValue);
        }
        if (again == 0) {
            again = diceType + 1;
        }
        if (again <= 1 || again < sucess) {
            throw new MyException(ExceptionInfo.ROLLER_SUCESSCOUNT_InvalidAgainValue);
        }

        String dice = String.valueOf(nbDice) + "d" + String.valueOf(diceType)
                + "/" + String.valueOf(sucess);
        if (again <= diceType) {
            dice = dice + ", " + String.valueOf(again) + " again";
        }
        int sucessCount = 0;
        String result = new String();
        for (int i = 1; i <= nbDice; i++) {
            int temp = RandomRoll(diceType);
            if (i != 1) {
                result = result + ",";
            }
            result = result + String.valueOf(temp);
            if (temp >= sucess) {
                sucessCount++;
            }
            while (temp >= again) {
                temp = RandomRoll(diceType);
                result = result + "," + String.valueOf(temp);
                if (temp >= sucess) {
                    sucessCount++;
                }
            }
        }
        result = result + " = " + String.valueOf(sucessCount);
        return new DiceResult(dice, result);
    }

    static public DiceResult RollLowerRoll(int diceType, int threshold) throws MyException {
        if (diceType < 1) {
            throw new MyException(ExceptionInfo.ROLLER_InvalidDiceType);
        }
        if (threshold < 1 || threshold > diceType) {
            throw new MyException(ExceptionInfo.ROLLER_THRESHOLD_InvalidThresholdValue);
        }

        String dice = "1d" + String.valueOf(diceType) + "/" + String.valueOf(threshold);
        int value = RandomRoll(diceType);
        String result;
        if (value < threshold) {
            result = String.valueOf(value) + " Sucess";
        } else {
            result = String.valueOf(value) + " Fail";
        }
        return new DiceResult(dice, result);
    }

    static public DiceResult RollKeepBest(int diceType, int nbDice, int keep, int bonus) throws MyException {
        if (diceType < 1) {
            throw new MyException(ExceptionInfo.ROLLER_InvalidDiceType);
        }
        if (nbDice < 1) {
            throw new MyException(ExceptionInfo.ROLLER_InvalidDiceNumber);
        }
        if (keep < 1 || keep > nbDice) {
            throw new MyException(ExceptionInfo.ROLLER_KEEP_InvalidKeepValue);
        }
        String dice = String.valueOf(nbDice) + "d" + String.valueOf(diceType)
                + "K" + String.valueOf(keep) + "+" + String.valueOf(bonus);
        int[] rolls = new int[nbDice];
        for (int i = 0; i < nbDice; i++) {
            rolls[i] = RandomRoll(diceType);
        }
        Arrays.sort(rolls);
        int total = 0;
        for (int i = 1; i <= keep; i++) {
            total = total + rolls[nbDice - i];
        }
        total = total + bonus;
        String result = new String();
        for (int i = 1; i <= nbDice; i++) {
            if (i != 1) {
                result = result + ",";
            }
            result = result + String.valueOf(rolls[nbDice - i]);
        }
        result = result + "+" + String.valueOf(bonus) + " = " + String.valueOf(total);
        return new DiceResult(dice, result);
    }
}
