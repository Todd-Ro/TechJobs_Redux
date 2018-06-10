package com.jetbrains.console;

import com.jetbrains.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with code from LaunchCode
 */
public class TechJobs {

    private static Scanner in = Main.in;

    // Returns the key of the selected item from the choices Dictionary
    public static String getUserSelection(String menuHeader, HashMap<String, String> choices) {

        Integer choiceIdx;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can ...
                // ... associate an Integer with each one
        Integer i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }

        do {

            System.out.println("\n" + menuHeader);

            // Print available choices
            for (Integer j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }

            choiceIdx = in.nextInt();
            in.nextLine();

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }
        } while(!validChoice);

        return choiceKeys[choiceIdx];
    }

    // Print a list of jobs
    public static void printJobs(ArrayList<HashMap<String, String>> someJobs) {
        if (someJobs.isEmpty()) {
            System.out.println("No jobs were found based on these criteria");
        }
        else {
            for (HashMap<String, String> row : someJobs) {
                System.out.println("*****");
                for (String key : row.keySet()) {
                    System.out.println(key + ": " + row.get(key));
                }
                System.out.println("*****"+"\n");
            }
        }
    }
}
