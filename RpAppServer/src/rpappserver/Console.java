/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpappserver;

/**
 *
 * @author Mathieu
 */
// TODO sortir les Println de ce code pour les mettres dans un gestionnaires (Multilingues?)
import DiceRoller.DiceResult;
import DiceRoller.Roller;
import MyException.RollerException;
import java.util.Scanner;

public class Console extends Thread {

    Scanner consoleInput = new Scanner(System.in);

    @Override
    public void run() {
        String lecture;
        do {
            System.out.print("Rp App Server > ");
            lecture = consoleInput.nextLine();
            lecture = lecture.toLowerCase();
            String command[] = lecture.split(" ");
            if (command[0].compareToIgnoreCase("exit") == 0) {
                System.out.println("\tclosing server");
            } else if (command[0].compareToIgnoreCase("SimpleRoll") == 0) {
                SimpleRoll(command);
            } else if (command[0].compareToIgnoreCase("SucessCount") == 0) {
                SucessCount(command);
            } else if (command[0].compareToIgnoreCase("LowerRoll") == 0) {
                LowerRoll(command);
            } else if (command[0].compareToIgnoreCase("KeepBest") == 0) {
                KeepBest(command);
            } else {
                System.out.println("\tUknown Command");
            }
        } while (lecture.compareTo("exit") != 0);
        Server.getServer().stopServer();
    }

    private void SimpleRoll(String[] command) {
        int diceType;
        int nbDice;
        int bonus = 0;
        /*
         * Gestion d'erreur
         */
        if (command.length < 3 || command.length > 4) {
            System.out.println("\tERROR! Invalide parameter number");
            return;
        }
        try {
            diceType = Integer.parseInt(command[1]);
            nbDice = Integer.parseInt(command[2]);
            if (command.length == 4) {
                bonus = Integer.parseInt(command[3]);
            }
        } catch (NumberFormatException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
            return;
        }
        /*
         * Gestion d'erreur
         */
        try {
            DiceResult result = Roller.RollSimpleRoll(diceType, nbDice, bonus);
            System.out.println(result.getTime() + "\t" + result.getRoll() + "\t" + result.getresult());
        } catch (RollerException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
        }
    }

    private void SucessCount(String[] command) {
        int diceType;
        int nbDice;
        int sucess;
        int again = 0;
        /*
         * Gestion d'erreur
         */
        if (command.length < 4 || command.length > 5) {
            System.out.println("\tERROR! Invalid parameter number");
            return;
        }
        try {
            diceType = Integer.parseInt(command[1]);
            nbDice = Integer.parseInt(command[2]);
            sucess = Integer.parseInt(command[3]);
            if (command.length == 5) {
                again = Integer.parseInt(command[4]);
            }
        } catch (NumberFormatException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
            return;
        }
        /*
         * Gestion d'erreur
         */
        try {
            DiceResult result = Roller.RollSucessCount(diceType, nbDice, sucess, again);
            System.out.println(result.getTime() + "\t" + result.getRoll() + "\t" + result.getresult());
        } catch (RollerException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
        }
    }

    private void LowerRoll(String[] command) {
        int diceType;
        int threshold;
        /*
         * Gestion d'erreur
         */
        if (command.length != 3) {
            System.out.println("\tERROR! Invalid parameter number");
            return;
        }
        try {
            diceType = Integer.parseInt(command[1]);
            threshold = Integer.parseInt(command[2]);
        } catch (NumberFormatException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
            return;
        }
        /*
         * Gestion d'erreur
         */
        try {
            DiceResult result = Roller.RollLowerRoll(diceType, threshold);
            System.out.println(result.getTime() + "\t" + result.getRoll() + "\t" + result.getresult());
        } catch (RollerException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
        }
    }

    private void KeepBest(String[] command) {
        int diceType;
        int nbDice;
        int keep;
        int bonus = 0;
        /*
         * Gestion d'erreur
         */
        if (command.length < 4 || command.length > 5) {
            System.out.println("\tERROR! Invalide parameter number");
            return;
        }
        try {
            diceType = Integer.parseInt(command[1]);
            nbDice = Integer.parseInt(command[2]);
            keep = Integer.parseInt(command[3]);
            if (command.length == 5) {
                bonus = Integer.parseInt(command[4]);
            }
        } catch (NumberFormatException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
            return;
        }
        /*
         * Gestion d'erreur
         */
        try {
            DiceResult result = Roller.RollKeepBest(diceType, nbDice, keep, bonus);
            System.out.println(result.getTime() + "\t" + result.getRoll() + "\t" + result.getresult());
        } catch (RollerException ex) {
            System.out.println("\tERROR! one or more invalide parameter");
        }
    }
}
