import java.util.Scanner;

public class Assik1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Task 1: Sum of Squares ---
        System.out.println("--- Task 1 ---");
        int n1 = 4;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + sumOfSquares(n1)); // Expected: 30

        // --- Task 2: Sum of first n elements of an array ---
        System.out.println("\n--- Task 2 ---");
        int[] arr = {1, 2, 3, 4, 5};
        int n2 = 3;
        System.out.println("Input: arr = [1, 2, 3, 4, 5], n = " + n2);
        System.out.println("Output: " + sumOfArray(arr, n2)); // Expected: 6

        // --- Task 3: Sum of first n powers of base b ---
        System.out.println("\n--- Task 3 ---");
        int b = 4;
        int n3 = 3;
        System.out.println("Input: b = " + b + ", n = " + n3);
        System.out.println("Output: " + sumOfPowers(b, n3)); // Expected: 85

        // --- Task 4: Reverse Sequence (No arrays, no loops) ---
        System.out.println("\n--- Task 4 ---");
        System.out.print("Enter N (followed by the sequence elements): ");
        if (scanner.hasNextInt()) {
            int n4 = scanner.nextInt();
            System.out.print("Sample Output: ");
            reverseSequence(scanner, n4);
            System.out.println();
        }

        scanner.close();
    }

    /**
     * Task 1: Returns the sum of the squares of the first n positive integers.
     * * Time Complexity: O(n) 
     * Explanation: The function makes a single recursive call for each number from n down to 1. 
     * Therefore, the number of operations is directly proportional to n.
     * * Space Complexity: O(n)
     * Explanation: Each recursive call adds a new frame to the call stack. For n calls, 
     * it requires O(n) memory on the stack.
     */
    public static int sumOfSquares(int n) {
        if (n <= 0) {
            return 0; // Base case
        }
        return (n * n) + sumOfSquares(n - 1); // Recursive step
    }

    /**
     * Task 2: Returns the sum of the first n elements of an array.
     * * Time Complexity: O(n)
     * Explanation: The function visits exactly n elements in the array once, resulting in O(n) time.
     * * Space Complexity: O(n)
     * Explanation: The maximum depth of the recursion tree is n, which means n stack frames 
     * are created in memory.
     */
    public static int sumOfArray(int[] arr, int n) {
        if (n <= 0) {
            return 0; // Base case: no elements left to sum
        }
        // arr[n-1] accesses the current nth element (0-indexed)
        return arr[n - 1] + sumOfArray(arr, n - 1); // Recursive step
    }

    /**
     * Task 3: Returns the sum of the first n powers of a base b.
     * * Time Complexity: O(n)
     * Explanation: The function decrements n by 1 in each recursive call until it reaches 0. 
     * Assuming Math.pow runs in constant O(1) time for integers, the overall time is O(n).
     * * Space Complexity: O(n)
     * Explanation: There are n + 1 recursive calls added to the call stack, leading to O(n) space.
     */
    public static int sumOfPowers(int b, int n) {
        if (n == 0) {
            return 1; // Base case: b^0 = 1
        }
        return (int) Math.pow(b, n) + sumOfPowers(b, n - 1); // Recursive step
    }

    /**
     * Task 4: Displays a given sequence of N elements in reverse order.
     * Constraints handled: No arrays declared, no loops used (even for input).
     * * Time Complexity: O(n)
     * Explanation: The function reads exactly n integers and makes n recursive calls.
     * * Space Complexity: O(n)
     * Explanation: Instead of storing elements in an array, the elements are implicitly stored 
     * in the local variables of the execution call stack. This requires O(n) space.
     */
    public static void reverseSequence(Scanner scanner, int n) {
        if (n <= 0) {
            return; // Base case: all elements have been read
        }

        // Read the current element from the scanner
        int currentElement = scanner.nextInt();

        // Recursive step: process the remaining n-1 elements FIRST
        reverseSequence(scanner, n - 1);

        // Print the current element AFTER the recursive call returns (prints in reverse)
        System.out.print(currentElement + " ");
    }
}