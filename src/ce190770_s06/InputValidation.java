/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s06;

import java.util.Scanner;

/**
 *
 *
 * @author Dinh Cong Phuc - CE190770 - 09/Feb/2025
 */
public class InputValidation {

    // Create a static Scanner object to read user input throughout the program
    public static Scanner sc = new Scanner(System.in);

    /**
     * Gets and validates integer input from user
     *
     * @return valid integer input from user
     */
    public static int getIntInput() {
        // Loop until valid input is received
        while (true) {
            try {
                // Parse user input as integer after trimming whitespace
                int in = Integer.parseInt(sc.nextLine().trim());
                return in;
            } catch (Exception e) {
                // Display error message if input cannot be parsed as integer
                System.out.print("Input is not a valid integer. Please try again: ");
            }
        }
    }

    /**
     * Validates positive integer input
     *
     * @return Valid positive integer
     */
    public static int getIntInputUnsigned() {
        // Loop until valid input is received
        while (true) {
            // Get integer input
            int in = getIntInput();
            // Check if input is positive
            if (in < 0) {
                System.out.print("Input must be larger than 0, Please try again. ");
            } else {
                return in;
            }
        }
    }

    /**
     * Validates integer input within specified range (inclusive min - inclusive
     * max)
     *
     * @param min Minimum allowed value
     * @param max Maximum allowed value
     * @return Valid integer within range
     */
    public static int getIntInputLimit(int min, int max) {
        // Loop until valid input is received
        while (true) {
            // Get integer input
            int in = getIntInput();
            // Check if input is within range
            if (in < min || in > max) {
                System.out.printf("Input must be between %d-%d.\n", min, max);
            } else {
                return in;
            }
        }
    }

    /**
     * Gets and validates optional integer input that can be null Allows empty
     * input to return null, otherwise ensures positive integer
     *
     * @return Integer object if valid input provided, null if empty input
     */
    public static Integer getIntInputOptional() {
        // Loop until valid input or empty input is received
        while (true) {
            // Read input and remove all whitespace
            String input = sc.nextLine().trim().replaceAll(" +", "");
            // Return null for empty input
            if (input.isEmpty()) {
                return null;
            }
            try {
                // Parse input as integer
                int in = Integer.parseInt(input);
                // Validate if number is non-negative
                if (in >= 0) {
                    return in;
                } else {
                    // Prompt for retry if number is negative
                    System.out.print("Input must be larger or equals 0. Please try again: ");
                }
            } catch (Exception e) {
                // Prompt for retry if input is not a valid integer
                System.out.print("Input is not a valid integer. Please try again: ");
            }
        }
    }

    /**
     * Gets and validates double input from user
     *
     * @return valid double input from user
     */
    public static double getDoubleInput() {
        // Loop until valid input is received
        while (true) {
            try {
                // Parse user input as double
                double in = Double.parseDouble(sc.nextLine().trim());
                return in;
            } catch (Exception e) {
                // Display error message for invalid input
                System.out.print("Input is not a valid double. Please try again: ");
            }
        }
    }

    /**
     * Gets and validates non-empty string input from at least 2 words
     *
     * @return valid non-empty string with normalized spaces
     */
    public static String getMultiStringNonEmpty() {
        // Continuous loop until valid input is received
        while (true) {
            // Reads input, trims whitespace, and normalizes spaces
            String in = sc.nextLine().trim().replaceAll(" +", " ");
            // Checks if input is not empty
            if (!in.isEmpty()) {
                // Returns valid input
                return in;
            } else {
                // Prompts user to enter non-empty input
                System.out.print("Input should not be empty. Please try again: ");
            }
        }
    }

    /**
     * Gets and validates non-empty string input
     *
     * @return string if valid
     */
    public static String getSingleStringNonEmpty() {
        // Continuous loop until valid input is received
        while (true) {
            // Reads input, trims whitespace, and normalizes spaces
            String in = sc.nextLine().trim().replaceAll(" +", "");
            // Checks if input is not empty
            if (!in.isEmpty()) {
                // Returns valid input
                return in;
            } else {
                // Prompts user to enter non-empty input
                System.out.print("Input should not be empty. Please try again: ");
            }
        }
    }

    /**
     * Gets and validates string input that must contain only letters and spaces
     * Uses regex to ensure no digits are present
     *
     * @return valid string containing only letters and spaces
     */
    public static String getNoDigitMultiString() {
        // Get non-empty string input first
        String in = getMultiStringNonEmpty();
        // Keep prompting until input contains only letters and spaces
        while (!in.matches("[a-zA-Z ]+")) {
            System.out.print("Please do not include number, try again:");
            in = getMultiStringNonEmpty();
        }
        return in;
    }
}
