import java.lang.classfile.constantpool.IntegerEntry;
import java.util.HashSet;

public class practice5 {


    import java.util.HashSet;

    public class TwoSumHashTable {

        public static void findPairs(int[] arr, int target) {
            // Create a Hash Table (specifically a HashSet since we only need the keys)
            HashSet<Integer> visited = new HashSet<>();

            // We only need a SINGLE loop
            for (int i = 0; i < arr.length; i++) { // if (int num : arr)
                int num = arr[i];
                int complement = target - num;

                // Check if the Hash Table already contains the complement
                if (visited.contains(complement)) {
                    return new int[]{complement , num};
                }
                visited.add(num); }return null;

                // Add the current number to the Hash Table so future numbers can check against it
                visited.add(num);
            }
        }
        public static void main(String[] args) {
            int[] numbers = {5, 3, 7, 8, 4, 3, 5, 8, 10, 14};
            int targetSum = 13;

            int[] result = findPairs(nums , target);
            if result != null
            if()

            System.out.println("Finding pairs that sum to " + targetSum + ":");
            findPairs(numbers, targetSum);
        }
    }
}
//import java.util.HashSet;
//
//public class TwoSumHashTable {
//
//    // The method now returns an int[] array instead of void
//    public static int[] findPairsFast(int[] arr, int target) {
//
//        // 1. Create the Hash Table to memorize numbers
//        HashSet<Integer> seenNumbers = new HashSet<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            int currentNum = arr[i];
//            int complement = target - currentNum;
//
//            // 2. Check if the Hash Table has the complement
//            if (seenNumbers.contains(complement)) {
//                // We found the pair! Return it immediately as a new array.
//                // This 'return' stops the loop and exits the method.
//                return new int[] { complement, currentNum };
//            }
//
//            // 3. If not found, add the current number to the Hash Table for future checks
//            seenNumbers.add(currentNum);
//        }
//
//        // 4. If the loop finishes and no pair is found, return null
//        return null;
//    }
//
//    public static void main(String[] args) {
//        int[] numbers = {5, 3, 7, 8, 4, 3, 5, 8, 10, 14};
//        int targetSum = 13;
//
//        // We call the method and store the returned array in the 'result' variable
//        int[] result = findPairsFast(numbers, targetSum);
//
//        // We do the if condition here in the main part!
//        // We check if the result is NOT null (meaning a pair was successfully returned)
//        if (result != null) {
//            System.out.println("Pair found: " + result + " and " + result[1]);
//        } else {
//            System.out.println("No pair sums up to " + targetSum);
//        }
//    }
//}
//System.out.println("Pair found: " + complement + " and " + num);

//in the main
//public static void main (String [] args ){
// int result = findPairs[]
// if result =! null
// sout pair found
// else
// sout pair not found }


// another code


//import java.util.HashSet;
//
//public class TwoSumHashTable {
//
//    public static int[] findPairsFast(int[] arr, int target) {
//        HashSet<Integer> seenNumbers = new HashSet<>();
//
//        // We use the enhanced 'for-each' loop here!
//        // This automatically reads "for each integer (which we'll call currentNum) inside 'arr'"
//        for (int currentNum : arr) {
//
//            // We no longer need to extract arr[i], we just use currentNum directly
//            int complement = target - currentNum;
//
//            if (seenNumbers.contains(complement)) {
//                return new int[] { complement, currentNum };
//            }
//
//            seenNumbers.add(currentNum);
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        int[] numbers = {5, 3, 7, 8, 4, 3, 5, 8, 10, 14};
//        int targetSum = 13;
//
//        int[] result = findPairsFast(numbers, targetSum);
//
//        if (result != null) {
//            // Arrays don't print nicely by themselves in Java, so we print the specific elements
//            System.out.println("Pair found: " + result + " and " + result[2]);
//        } else {
//            System.out.println("No pair sums up to " + targetSum);
//        }
//    }
//}