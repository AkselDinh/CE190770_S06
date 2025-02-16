/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s06;

/**
 *
 * @author PD
 */
public class UI {

    int[] arr = new int[100];
//    int [] arr = {1, 2, 3, -6, 10, 8, 5}; //testing
    int arrSize = 0;
    private int selection;

    public void loop() {
        do {
            printMenu();
            selection();

        } while (selection >= 1 && selection <= 5);
    }

    public void printMenu() {
        System.out.println("1- Add a value");
        System.out.println("2- Search a value");
        System.out.println("3- Print out the array");
        System.out.println("4- Print out values in a range of inputted min and max values, inclusively");
        System.out.println("5- Sort the array in ascending order");
        System.out.println("Others- Quit");
    }

    public void selection() {
        System.out.print("Please select an option: ");
        selection = InputValidation.getIntInput();
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

    public void arrAddValue() {
        System.out.print("Please input a value: ");
        int input = InputValidation.getIntInput();
        arrSize++;
        arr[arrSize - 1] = input;
    }

    public void arrSearchValue() {
        boolean found = false;
        int i;
        
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.print("Please input a value to search: ");
            int input = InputValidation.getIntInput();
            for (i = 0; i < arrSize; i++) {
                if (input == arr[i]) {
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Value not found in array");
            } else {
                System.out.printf("Found value at index: %d\n", i);
            }
        }
    }

    public void arrPrint() {
        String str = new String();
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            for (int i = 0; i < arrSize; i++) {
                str += arr[i] + ", ";
            }
            System.out.println(str.substring(0, str.length() - 2));
        }
    }

    public void arrPrintMinMax() {
        String str = new String();
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.print("Please input min: ");
            int min = InputValidation.getIntInput();
            System.out.print("Please input max: ");
            int max = InputValidation.getIntInput();

           try{
                for (int i = 0; i < arrSize; i++) {
                    if (arr[i] >= min && arr[i] <= max) {
                        str += arr[i] + ", ";
                    }
                }
                System.out.println(str.substring(0, str.length() - 2));
            } catch (Exception e){
                System.out.println("Invalid range");
            }
        }

    }

    public void arrSort() {
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            mergeSortArray.mergeSort(arr);
            System.out.println("Sorted complete:");
            arrPrint();
        }
    }

}
