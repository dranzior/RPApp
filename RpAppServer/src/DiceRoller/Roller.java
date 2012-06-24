/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoller;

import MyException.RollerException;

/**
 *
 * @author Mathieu
 */
public class Roller {

    static private int randomRoll(int diceType) {
        //Random rnd = new Random();
        double result = (int) ((Math.random() * (diceType)) + 1);
        return (int) result;
    }

    static public DiceResult RollSimpleRoll(int diceType, int nbDice, int bonus) throws RollerException {
        if (diceType < 1)
            throw new RollerException("Invalid Dice Type");
        if (nbDice < 1)
            throw new RollerException("No Dice to roll");

        String dice = String.valueOf(nbDice) + "d" + String.valueOf(diceType) + "+" + String.valueOf(bonus);
        int total = 0;
        String result = new String();
        for (int i = 1; i <= nbDice; i++) {
            int temp = randomRoll(diceType);
            if (i != 1) 
                result = result + ",";
            result = result + String.valueOf(temp);
            total = total + temp;
        }
        total = total + bonus;
        result = result + " + " + String.valueOf(bonus) + " = " + String.valueOf(total);
        return new DiceResult(dice, result);
    }
    
    static public DiceResult RollSucessCount(int diceType, int nbDice, int sucess, int again) throws RollerException {
        if (diceType < 1)
            throw new RollerException("Invalid Dice Type");
        if (nbDice < 1)
            throw new RollerException("No Dice to roll");
        if (sucess < 1 || sucess > diceType)
            throw new RollerException("Invalid sucess value");
        if (again == 0)
            again = diceType+1;
        if (again <= 1 || again < sucess)
            throw new RollerException("Invalid RollAgain value");
        
        String dice = String.valueOf(nbDice) + "d" + String.valueOf(diceType) + 
                "/" + String.valueOf(sucess);
        if (again <= diceType) 
                dice = dice + ", " + String.valueOf(again) + " again";
        int sucessCount = 0;
        String result = new String();
        for (int i = 1; i <= nbDice; i++) {
            int temp = randomRoll(diceType);
            if (i != 1)
                result = result + ",";
            result = result + String.valueOf(temp);
            if (temp >= sucess)
                sucessCount++;
            while (temp >= again) {
                temp = randomRoll(diceType);
                result = result + "," + String.valueOf(temp);
                if (temp >= sucess)
                    sucessCount++;
            }
        }
        result = result + " = " + String.valueOf(sucessCount);
        return new DiceResult(dice, result);
    }
    // TODO Test
    static public DiceResult RollLowerRoll(int diceType, int threshold) throws RollerException{
        if (diceType < 1)
            throw new RollerException("Invalid Dice Type");
        if (threshold < 1 || threshold > diceType)
            throw new RollerException("Invalid threshold");
        
        String dice = "1d" + String.valueOf(diceType) + "/" + String.valueOf(threshold);
        int value = randomRoll(diceType);
        String result;
        if (value < threshold)
            result = String.valueOf(value) + "Sucess";
        else
            result = String.valueOf(value) + "Fail";
        return new DiceResult(dice,result);
    }
    
    static public DiceResult RollKeepBest(int diceType, int nbDice, int keep, int bonus) {
        return new DiceResult("temp","temp");
    }
}
