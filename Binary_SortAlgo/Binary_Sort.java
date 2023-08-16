

import java.util.*;
import java.util.stream.IntStream;

class Binary_Sort{
    public static void bubbleSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        System.out.println("After been sorted");
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }

    public static void binarySearch(int[] arr, int [] passed, int first, int last,int password,int key ) {
        // test is  searching the array to see if  you PASSWORD is in the passed  ID's
        boolean test = IntStream.of(passed).anyMatch(x -> x == password);
        System.out.println(key);
        if(test ){
            //binarySearch
            int mid = (first + last) / 2;
            while (first <= last) {
                if (arr[mid] < key) {
                    first = mid + 1;
                } else if (arr[mid] == key ) {
                    System.out.println("Your keyword " + password + " and you have collect  "
                            + key +" and your place are " + mid );
                    break;
                } else {
                    last = mid - 1;
                }
                    mid = (first + last) / 2;
            }
                if (first > last) {
                    System.out.println("Keyword not found!");
                }
            }else {
            System.out.println("1 ");
            System.out.println("Sorry U didnt make it :/ ");
        }
    }

    public static void main(String args[]) {
        int arr[] = new int[100];
        int last = arr.length - 1;

        System.out.println("See if you are at top 70% \nBy typing your password: ");
        Scanner scan= new Scanner(System.in);
        if (scan.hasNextInt()) {
            int password = scan.nextInt();

            int[] passed = new int[100];
            int l = passed.length ;

            System.out.println("The passwords which was passed: " );
            for(int k = 0 ; k < l; k++){
                passed[k] = k;  //rb.nextInt(100);
                System.out.print(passed[k] + " ");
            }
            System.out.println("");
            Random rb = new Random();
            for (int k = 0; k < arr.length; k++) {
                arr[k] = rb.nextInt(70,100);
            }

            System.out.println("Array of values Before sort");
            for (int j : arr)
                System.out.print(j + " ");
            System.out.println();

            int key = arr[password];
            bubbleSort(arr);
            binarySearch(arr,passed, 0, last, password,key);
        } else {
            System.out.println("Sorry you didnt typed your correct password ");
        }
    }
}
