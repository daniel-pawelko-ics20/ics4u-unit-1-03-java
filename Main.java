/*
* Calculate cook time
*
* @author  Daniel
* @version 1.0
* @since   2022-10-14
*/

import java.util.Scanner;

/**
* Program calculates microwave cook time.
*/
final class Main {

    /**
    * Prevent instantiation.
    *
    * @throws IllegalStateException
    *
    */

    private Main() {
        throw new IllegalStateException("Cannot be instantiated");
    }
    /**
    * Function gets index of String in arr.
    *
    * @param arr Array that is searched
    * @param word String that is searched
    * @return return the index found
    */

    public static int includes(String[] arr, String word) {
        int counter = 0;
        for (String s : arr) {
            if (word.equals(s)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    /**
    * Program calculates microwave cook time.
    *
    * @param args No args will be used
    */

    public static void main(final String[] args) {
        // Defining variables
        final Scanner s = new Scanner(System.in);
        final String[] OPTIONS = {"sub", "pizza", "soup"};
        final double[] OPTIONSTIME = {1.0, 0.75, 1.75};
        String food = "";
        final int mass = 0;

        // Getting user input
        while (includes(OPTIONS, food) < 0) {
            System.out.print("Food(pizza, sub, or soup): ");
            food = s.next();
            food = food.toLowerCase();
            food = food.strip();
        }

        // Getting user input
        System.out.print("How many " + food + "(s) are you cooking(max:3):");
        final String amountString = s.next();

        try {
            // Convert string to integer
            final double amount = Double.valueOf(amountString);

            if (amount <= 0) {
                System.out.println("Amount cannot be negative");
            } else if (amount >= 4.0) {
                System.out.println("The maximum quantity of food is 3.");
            } else {
                // Calculations
                final double timeOfOne = OPTIONSTIME[includes(OPTIONS, food)];
                final double timeUnFormated =
                    timeOfOne + timeOfOne * ((amount - 1) * 0.5);
                final double seconds = 60 * (timeUnFormated % 1);
                final double minutes = timeUnFormated - (timeUnFormated % 1);

                // Output
                System.out.println("The total cook time is " + minutes
                    + " minutes and " + seconds + " seconds.");
            }

        } catch (NumberFormatException ex) {
            // Exception
            System.out.println("Input invalid :(");
        } finally {
            // Done
            System.out.println("\nDone");
        }
    }
}
