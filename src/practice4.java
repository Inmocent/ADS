

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


public class practice4 {
public static void main(String[] args) {
    int arr numbers = {5, 3, 7, 8, 4, 3, 5, 8, 10, 14} ;
    int target = 13;
    System.out.println("Finding pairs that sum to " + targetSum + ":");
    findPairs(numbers, targetSum);

}

   ///public static void  sumPairs(int[] arr , int  target ){
    int n = arr.length;
   for(int i = 0 ; i<n ; i++]){
       for(int j= i+1 ; j < n ; j++){
           if(arr[i] + arr[j] =! target){
               return "not that one" ;
           }else if (arr[i] + arr[j] == target ){
               return "that is right ";
           }
       }
    }
// itn[] result = findpairs (num . target);

       for(int i = 0 ; i < n ; i ++  ){
           int first = a6 [i];
           if (i == 0 ) return ;
            return first + first (i+1);
       }
 ///

           public static void findPairs(int[] arr, int target) {
               int n = arr.length;

               // The outer loop picks the first element of the pair
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {

                       // Check if the two selected elements sum to the target
                       if (arr[i] + arr[j] == target) {
                           System.out.println("Pair found: " + arr[i] + " and " + arr[j]);
                       }
                   }
               }
           }
   }
   }



           // 13 target 13 = 5 (8)  - 10 - 6  - 8 = 5 8 = 13
// try to make with scanner
// if condition empty
