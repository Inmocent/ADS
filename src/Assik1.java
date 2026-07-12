import java.util.Scanner;

public class Assik1 {
    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);

        System.out.println("=== Assik 1 Tasks ===");
        System.out.println("1: Run Task 1 (Sum of Powers - Always Power of 2)");
        System.out.println("2: Run Task 2 (Sum of First N Array)");
        System.out.println("3: Run Task 3 (Base Power Sum - From 0 to n-1)");
        System.out.println("4: Run Task 4 (Reverse Sequence)");
        System.out.print("Enter the number of the task you want to run (1-4): ");

        int choice = mainScanner.nextInt();
        System.out.println("--------------------------------------------------");

        // Using a switch statement to call the selected task's main method
        switch (choice) {
            case 1:
                PowerSumCalculator.main(args);
                break;
            case 2:
                SumofFirst.main(args);
                break;
            case 3:
                BasePowerSumCalculator.main(args);
                break;
            case 4:
                ReverseSequence.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please run the program again.");
                break;
        }
    }
}

// t1
class PowerSumCalculator {

    public static int sumOfPowers(int n, int b) {
        if (n <= 0) {
            return 0; // end recursion when it equals to 0
        }
        return power(n, b) + sumOfPowers(n - 1, b);
    }

    public static int power(int n, int b) {
        int ans = 1;
        // for loop for multiplication
        for (int i = 0; i < b; i++) {
            ans *= n;
        }
        return ans; // saving up the progress
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements (n): ");
        int n = sc.nextInt();

        // The power is now hardcoded to always be 2
        int b = 2;

        int result = sumOfPowers(n, b);
        System.out.println("The sum of the first " + n + " integers raised to the power of 2 is: " + result);
    }
}

// t2
class SumofFirst {

    public static int sumArray(int[] arr, int n) {
        if (n <= 0) { // base case
            return 0;
        }
        // recursion idea is to sum the value with the others by the index which starts from 0 that is why n-1
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the maximum number (n): ");
        int n = sc.nextInt();

        // Create an array of size n and fill it with 1, 2, 3 ... n
        int[] myArray = new int[n];
        for (int i = 0; i < n; i++) {
            myArray[i] = i + 1;
        }

        int total = sumArray(myArray, n);
        System.out.println("The sum of the first " + n + " numbers = " + total);
    }
}

// t3
class BasePowerSumCalculator {

    public static int sumOfBasePowers(int b, int currentPower) {

        if (currentPower < 0) {
            return 0;
        }
        return power(b, currentPower) + sumOfBasePowers(b, currentPower - 1);
    }

    public static int power(int b, int n) {
        int ans = 1;
        //  loop will safely not run if n is 0, returning 1 (which is correct for b^0)
        for (int i = 0; i < n; i++) {
            ans *= b;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base (b): ");
        int b = sc.nextInt();

        System.out.print("Enter the number of powers (n): ");
        int n = sc.nextInt();

        // pass n - 1 to start from the highest required power and go down to 0
        int total = sumOfBasePowers(b, n - 1);
        System.out.println("The sum of the first " + n + " powers (from 0 to " + (n - 1) + ") of base " + b + " is: " + total);
    }
}

// t4
class ReverseSequence {

    public static void printInReverse(int n, Scanner sc) {
        // base case
        if (n <= 0) {
            return;
        }
        // read from input
        int currentElement = sc.nextInt();

        printInReverse(n - 1, sc);
        // lifo order
        System.out.print(currentElement + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements (n): ");
        int n = sc.nextInt();

        System.out.println("Enter the " + n + " elements:");
        // call the recursive function without using any loops
        printInReverse(n, sc);
    }
}