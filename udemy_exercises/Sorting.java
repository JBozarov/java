package udemy_exercises;

import java.util.Scanner;

class Sorting {
    private static Scanner scanner = new Scanner(System.in);
    static int[] arr  = {12,46,2,99,45,66,45};


    public static void main(String[] args) {

        System.out.println("Printing all numbers");
        printNums(arr);

        System.out.println("Reversing all numbers and printing to check ");
        int[] newArr = reverse(arr);
        printNums(newArr);

        System.out.println("Sorting Descending order and printing to check ");
        sortDescendingOrder(arr);
        printNums(arr);

        System.out.println("Sorting Ascending order and printing to check ");
        sortAscendingOrder(arr);
        printNums(arr);

        System.out.println("Entering new array");
        int[] enteredArray = getNums();
        printNums(enteredArray);

    }

    // print all numbers method
    static void printNums(int[] nums) {
        for ( int i = 0; i<nums.length; i++ ) {
            System.out.println(nums[i]);
        }
    }

    // Entering an new array from console
    public static int[] getNums () {
        System.out.println("Enter the length of new array: ");
        int arrLength;
        arrLength = scanner.nextInt();
        int[] newArr = new int[arrLength];
        for ( int g = 0; g<arrLength; g++ ) {
            System.out.println("Please enter the next number " + ( arrLength-g ) + " entries left ");
            int inputValue = scanner.nextInt();
            newArr[g] = inputValue;
        }
        return newArr;

    }



    // sorting in descending order
    public static void sortDescendingOrder(int[] nums) {
        boolean flag = true;
        int temp = 0;
        while(flag) {
            flag = false;
            for ( int k = 0; k<nums.length-1; k++ ) {
                if (nums[k]<nums[k+1]){
                    temp = nums[k];
                    nums[k]=nums[k+1];
                    nums[k+1]=temp;
                    flag = true;
                }
            }
        }
    }


    // sorting in ascending order
    public static void sortAscendingOrder(int[] nums) {
        boolean flag = true;
        int temp = 0;
        while(flag) {
            flag = false;
            for ( int k = 0; k<nums.length-1; k++ ) {
                if (nums[k]>nums[k+1]){
                    temp = nums[k];
                    nums[k]=nums[k+1];
                    nums[k+1]=temp;
                    flag = true;
                }
            }
        }
    }


    // reverse method
    static int[] reverse(int[] numbers) {
        int[] reversed = new int[numbers.length];
        for ( int i = 0; i<numbers.length; i++ ) {
            reversed[i] = numbers[numbers.length-1-i];
        }
        return reversed;
    }


}
