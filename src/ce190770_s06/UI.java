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

    ArrayCtrl arrCtrl = new ArrayCtrl();
    // Stores the user's menu selection
    private int selection;

    /**
     * Main program loop that displays menu and handles user input Continues
     * until user selects an option outside 1-5
     */
    public void loop() {
        do {
            printMenu();
            selection();
        } while (selection >= 1 && selection <= 5);
    }

    /**
     * Displays the main menu options to the user
     */
    public void printMenu() {
        System.out.println("1- Add a value");
        System.out.println("2- Search a value");
        System.out.println("3- Print out the array");
        System.out.println("4- Print out values in a range of inputted min and max values, inclusively");
        System.out.println("5- Sort the array in ascending order");
        System.out.println("Others- Quit");
    }

    /**
     * Handles user menu selection and calls appropriate function
     */
    public void selection() {
        System.out.print("Please select an option: ");
        // Get valid integer input from user
        selection = InputValidation.getIntInput();
        // Process user selection
        switch (selection) {
            case 1:
                arrCtrl.arrAddValue();
                break;
            case 2:
                arrCtrl.arrSearchValue();
                break;
            case 3:
                arrCtrl.arrPrint();
                break;
            case 4:
                arrCtrl.arrPrintMinMax();
                break;
            case 5:
                arrCtrl.arrSort();
                break;
            default:
                break;
        }
    }

}
