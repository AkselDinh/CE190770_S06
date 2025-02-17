/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s06;

/**
 * S06 - Array Manipulation Program User Interface class that handles all user
 * interactions and array operations
 *
 * @author Dinh Cong Phuc - CE190770 - 09/Feb/2025
 */
public class UI {

    // Create instance of ArrayCtrl to handle array operations
    private ArrayCtrl arrCtrl = new ArrayCtrl();
    // Variable to store user's menu selection
    private int selection;

    /**
     * Main program loop that displays menu and handles user input Continues
     * until user selects an option outside 1-5
     */
    public void loop() {
        // Continue loop while selection is between 1 and 5
        do {
            // Display the menu options
            printMenu();
            // Get and process user selection
            selection();
        } while (selection >= 1 && selection <= 5);
    }

    /**
     * Displays each menu option to the user by printing them line by line
     */
    public void printMenu() {
        // Display option 1 for adding a value to the array
        System.out.println("1- Add a value");
        // Display option 2 for searching a value in the array
        System.out.println("2- Search a value");
        // Display option 3 for printing all array elements
        System.out.println("3- Print out the array");
        // Display option 4 for printing values within a specified range
        System.out.println("4- Print out values in a range of inputted min and max values, inclusively");
        // Display option 5 for sorting the array
        System.out.println("5- Sort the array in ascending order");
        // Display instruction for quitting the program
        System.out.println("Others- Quit");
    }

    /**
     * Handles user menu selection and calls appropriate function
     */
    public void selection() {
        System.out.print("Please select an option: ");
        // Get valid integer input from user
        selection = InputValidation.getIntInput();
        // Begin switch statement based on user's menu selection
        switch (selection) {
            // If user selected option 1
            case 1:
                // Call method to add a new value to array
                arrCtrl.arrAddValue();
                // Exit the case
                break;
            // If user selected option 2
            case 2:
                // Call method to search for a value in array
                arrCtrl.arrSearchValue();
                // Exit the case
                break;
            // If user selected option 3
            case 3:
                // Call method to print all array elements
                arrCtrl.arrPrint();
                // Exit the case
                break;
            // If user selected option 4
            case 4:
                // Call method to print values within specified range
                arrCtrl.arrPrintMinMax();
                // Exit the case
                break;
            // If user selected option 5
            case 5:
                // Call method to sort the array
                arrCtrl.arrSort();
                // Exit the case
                break;
            // If user selected any other option
            default:
                // Exit the switch statement (program will end)
                break;
        }
    }

}
