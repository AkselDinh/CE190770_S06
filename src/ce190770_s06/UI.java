/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s06;

/**
 * S06 - Array Manipulation Program
 * User Interface class that handles all user interactions and array operations
 * 
 * @author Dinh Cong Phuc - CE190770 - 09/Feb/2025
 */
public class UI {
    // Array to store integer values with fixed size of 100
    int[] arr = new int[100];
    // Alternative test array (commented out)
    //int [] arr = {1, 2, 3, -6, 10, 8, 5}; //testing
    
    // Tracks the current number of elements in the array
    int arrSize = 0;
    // Stores the user's menu selection
    private int selection;

    /**
     * Main program loop that displays menu and handles user input
     * Continues until user selects an option outside 1-5
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
                arrAddValue();
                break;
            case 2:
                arrSearchValue();
                break;
            case 3:
                arrPrint();
                break;
            case 4:
                arrPrintMinMax();
                break;
            case 5:
                arrSort();
                break;
            default:
                break;
        }
    }

    /**
     * Adds a new value to the array
     */
    public void arrAddValue() {
        System.out.print("Please input a value: ");
        // Get valid integer input from user
        int input = InputValidation.getIntInput();
        // Increment array size and add new value
        arrSize++;
        arr[arrSize - 1] = input;
    }

    /**
     * Searches for a value in the array and displays its index if found
     */
    public void arrSearchValue() {
        boolean found = false;
        int i;
        
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.print("Please input a value to search: ");
            // Get value to search for
            int input = InputValidation.getIntInput();
            // Search through array
            for (i = 0; i < arrSize; i++) {
                if (input == arr[i]) {
                    found = true;
                    break;
                }
            }
            // Display search results
            if(!found){
                System.out.println("Value not found in array");
            } else {
                System.out.printf("Found value at index: %d\n", i);
            }
        }
    }

    /**
     * Prints all values currently in the array
     */
    public void arrPrint() {
        String str = new String();
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            // Build string of array values
            for (int i = 0; i < arrSize; i++) {
                str += arr[i] + ", ";
            }
            // Remove trailing comma and space
            System.out.println(str.substring(0, str.length() - 2));
        }
    }

    /**
     * Prints values that fall within a user-specified range
     */
    public void arrPrintMinMax() {
        String str = new String();
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            // Get range bounds from user
            System.out.print("Please input min: ");
            int min = InputValidation.getIntInput();
            System.out.print("Please input max: ");
            int max = InputValidation.getIntInput();

            try {
                // Build string of values within range
                for (int i = 0; i < arrSize; i++) {
                    if (arr[i] >= min && arr[i] <= max) {
                        str += arr[i] + ", ";
                    }
                }
                // Remove trailing comma and space
                System.out.println(str.substring(0, str.length() - 2));
            } catch (Exception e) {
                System.out.println("Invalid range");
            }
        }
    }

    /**
     * Sorts the array in ascending order using merge sort
     */
    public void arrSort() {
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            // Create temporary array of actual elements
            int[] tempArr = new int[arrSize];
            for(int i = 0; i < arrSize; i++){
                tempArr[i] = arr[i];
            }
            
            // Sort temporary array
            mergeSortArray.mergeSort(tempArr);
            
            // Copy sorted values back to original array
            for(int i = 0; i < arrSize; i++){
                arr[i] = tempArr[i];
            }
            System.out.println("Sorted complete:");
            arrPrint();
        }
    }
}
