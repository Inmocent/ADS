import java.util.Scanner;
import java.util.ArrayList; // Added this import
import java.util.Arrays;    // Added this import to easily print arrays

public class practice {
    public static void main(String[] args) {
        int[] numbers1 = {87, 14, 52, 91, 3, 66, 29, 78, 45, 12};
        int[] numbers2 = {55, 31, 8, 99, 72, 19, 44, 83, 61, 26};
        int[] numbers3 = {10, 67, 34, 95, 22, 79, 48, 5, 88, 51};
        int[] numbers4 = {76, 23, 60, 7, 94, 41, 16, 58, 85, 39};
        int[] numbers5 = {36, 92, 18, 71, 49, 2, 84, 57, 13, 63};
        int[] numbers6 = {47, 81, 25, 9, 68, 32, 90, 53, 11, 74};
        int[] numbers7 = {62, 15, 86, 43, 4, 77, 28, 96, 50, 21};
        int[] numbers8 = {89, 37, 6, 75, 59, 17, 82, 40, 93, 24};
        int[] numbers9 = {20, 65, 46, 80, 1, 54, 98, 30, 70, 35};
        int[] numbers10 = {97, 27, 69, 42, 86, 11, 52, 73, 38, 64};


        System.out.println(findMax(numbers1));
        System.out.println(contains(numbers2, 20));
        printPairs(numbers3);

    }


    //task 1
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    //timecomplexity is O(n) because of the for loop and the condition of the length of an array which will be dynamic

    //task 2
    public static boolean contains(int[] arr, int target) {
        for (int num : arr) { // meaning that num is containing in the array (:)
            if (num == target) {
                return true;
            }
        }
        return false;
    }
    //time complexity is depend on the position and target number itself cause the position represent the index O(n)
//*
    //task 3
    public static void printPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // Adding brackets, a comma, and a space at the very end!
                System.out.print("[" + arr[i] + ", " + arr[j] + "] ");
            }
            // This drops you to the next line after a row of 10 is finished
            System.out.println();
        }
    }


    //nested looop in the for loop multiplication law O(n) * O(n) depended  , law addition as like in the propability is independed the sum up
    // cause of the case liek O(2n) can easily be writed like 0N

    //task 4
    public static void uniquePairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }

    //task 5
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //task 6
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // may have be the log n

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;// it extrimely slow grow up conditioning
        }
        return -1;
    }
    // just because of the cutting out the half of it may be the O(n log n)

    //task 7
    public static void doublingLoop(int n) {
        for (int i = 1; i < n; i *= 2) {
            System.out.println(i);
        }
    }
    //time complexity O(log n ) cause of it double each time iteration which tends to this type

    // task 8
    public static void tripleLoop(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println(arr[i] + arr[j] + arr[k]);
                }
            }
        }
    }
    //O(n^3) time complexity cause of the nested triple loops in here with the linear additions without any dependencies

    //task 9
    public static ArrayList<Integer> buildList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }
    //O(n) just adds the list in here

    //task 10
    public static void insertAtBeginning(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }
    }
    //O(n^2) cause of the list.add(0,i) makes dependent the index and the inserted value too so O(n) * O(n) formula
}

