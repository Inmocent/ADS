import java.util.Scanner;

public class Assignment3 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to Assignment 3!");

        while (isRunning) {
            System.out.println("\nSelect a task to run:");
            System.out.println("1 - Check Anagrams (Task 1)");
            System.out.println("2 - Find K-th Smallest Element (Task 2)");
            System.out.println("3 - Find Median Element (Task 3)");
            System.out.println("4 - Optimal Shipping Capacity (Task 4)");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            int userChoice = userInput.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter the first word: ");
                    String firstWord = userInput.next();
                    System.out.print("Enter the second word: ");
                    String secondWord = userInput.next();

                    boolean isAnagram = checkIfAnagrams(firstWord, secondWord);
                    if (isAnagram) {
                        System.out.println("Output: YES");
                    } else {
                        System.out.println("Output: NO");
                    }
                    break;

                case 2:
                    System.out.print("Enter the size of the array: ");
                    int arraySize = userInput.nextInt();
                    int[] elements = new int[arraySize];

                    System.out.print("Enter " + arraySize + " space-separated numbers: ");
                    for (int index = 0; index < arraySize; index++) {
                        elements[index] = userInput.nextInt();
                    }

                    System.out.print("Enter the k-th smallest position to find: ");
                    int kthPosition = userInput.nextInt();

                    int kthSmallest = findKthSmallestElement(elements, kthPosition);
                    System.out.println("Output: " + kthSmallest);
                    break;

                case 3:
                    System.out.print("Enter the size of the array: ");
                    int medianArraySize = userInput.nextInt();
                    int[] medianElements = new int[medianArraySize];

                    System.out.print("Enter " + medianArraySize + " space-separated numbers: ");
                    for (int index = 0; index < medianArraySize; index++) {
                        medianElements[index] = userInput.nextInt();
                    }

                    int medianValue = calculateMedian(medianElements);
                    System.out.println("Output: " + medianValue);
                    break;

                case 4:
                    System.out.print("Enter the number of packages: ");
                    int packagesCount = userInput.nextInt();
                    int[] weights = new int[packagesCount];

                    System.out.print("Enter the weights of the packages: ");
                    for (int index = 0; index < packagesCount; index++) {
                        weights[index] = userInput.nextInt();
                    }

                    System.out.print("Enter the target number of days: ");
                    int targetDays = userInput.nextInt();

                    int optimalCapacity = findOptimalShippingCapacity(weights, targetDays);
                    System.out.println("Output (Optimal Capacity): " + optimalCapacity);
                    break;

                case 0:
                    isRunning = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        userInput.close();
    }

//t1
    public static boolean checkIfAnagrams(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        char[] firstCharacterArray = firstWord.toCharArray();
        char[] secondCharacterArray = secondWord.toCharArray();

        sortCharacterArray(firstCharacterArray);
        sortCharacterArray(secondCharacterArray);

        for (int index = 0; index < firstCharacterArray.length; index++) {
            if (firstCharacterArray[index] != secondCharacterArray[index]) {
                return false;
            }
        }
        return true;
    }

    private static void sortCharacterArray(char[] characters) {
        int arrayLength = characters.length;
        for (int outerPass = 0; outerPass < arrayLength - 1; outerPass++) {
            for (int innerPass = 0; innerPass < arrayLength - 1 - outerPass; innerPass++) {
                if (characters[innerPass] > characters[innerPass + 1]) {
                    char temporaryCharacter = characters[innerPass];
                    characters[innerPass] = characters[innerPass + 1];
                    characters[innerPass + 1] = temporaryCharacter;
                }
            }
        }
    }

//t2
    public static int findKthSmallestElement(int[] numbers, int k) {
        sortWithQuickSort(numbers, 0, numbers.length - 1);
        return numbers[k - 1]; // Pick element at index k-1 as requested in the document
    }

    private static void sortWithQuickSort(int[] numbers, int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) return;
        int partitionIndex = partitionArrayForQuickSort(numbers, lowerBound, upperBound);
        sortWithQuickSort(numbers, lowerBound, partitionIndex - 1);
        sortWithQuickSort(numbers, partitionIndex + 1, upperBound);
    }

    private static int partitionArrayForQuickSort(int[] numbers, int lowerBound, int upperBound) {
        int pivotValue = numbers[lowerBound];
        int leftScanPointer = lowerBound;
        int rightScanPointer = upperBound + 1;

        while (true) {
            while (numbers[++leftScanPointer] < pivotValue) {
                if (leftScanPointer == upperBound) break;
            }
            while (numbers[--rightScanPointer] > pivotValue) {
                if (rightScanPointer == lowerBound) break;
            }
            if (leftScanPointer >= rightScanPointer) break;

            int temporarySwap = numbers[leftScanPointer];
            numbers[leftScanPointer] = numbers[rightScanPointer];
            numbers[rightScanPointer] = temporarySwap;
        }

        int temporarySwap = numbers[lowerBound];
        numbers[lowerBound] = numbers[rightScanPointer];
        numbers[rightScanPointer] = temporarySwap;

        return rightScanPointer;
    }

//t3
    public static int calculateMedian(int[] numbers) {
        int[] auxiliaryArray = new int[numbers.length];
        performMergeSort(numbers, auxiliaryArray, 0, numbers.length - 1);

        int middleIndex = numbers.length / 2;
        return numbers[middleIndex];
    }

    private static void performMergeSort(int[] numbers, int[] auxiliaryArray, int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) return;
        int middleIndex = lowerBound + (upperBound - lowerBound) / 2;

        performMergeSort(numbers, auxiliaryArray, lowerBound, middleIndex);
        performMergeSort(numbers, auxiliaryArray, middleIndex + 1, upperBound);
        mergeHalves(numbers, auxiliaryArray, lowerBound, middleIndex, upperBound);
    }

    private static void mergeHalves(int[] numbers, int[] auxiliaryArray, int lowerBound, int middleIndex, int upperBound) {
        for (int index = lowerBound; index <= upperBound; index++) {
            auxiliaryArray[index] = numbers[index];
        }

        int leftPointer = lowerBound;
        int rightPointer = middleIndex + 1;

        for (int index = lowerBound; index <= upperBound; index++) {
            if (leftPointer > middleIndex) {
                numbers[index] = auxiliaryArray[rightPointer++];
            } else if (rightPointer > upperBound) {
                numbers[index] = auxiliaryArray[leftPointer++];
            } else if (auxiliaryArray[rightPointer] < auxiliaryArray[leftPointer]) {
                numbers[index] = auxiliaryArray[rightPointer++];
            } else {
                numbers[index] = auxiliaryArray[leftPointer++];
            }
        }
    }

 // t4
    public static int findOptimalShippingCapacity(int[] weights, int targetDays) {
        int maximumSingleWeight = 0;
        int totalWeightSum = 0;

        for (int weight : weights) {
            if (weight > maximumSingleWeight) {
                maximumSingleWeight = weight;
            }
            totalWeightSum += weight;
        }

        int lowerCapacityBound = maximumSingleWeight;
        int upperCapacityBound = totalWeightSum;
        int optimalCapacityFound = upperCapacityBound;

        while (lowerCapacityBound <= upperCapacityBound) {
            int middleCapacityTest = lowerCapacityBound + (upperCapacityBound - lowerCapacityBound) / 2;

            if (canShipPackagesWithinDays(weights, targetDays, middleCapacityTest)) {
                optimalCapacityFound = middleCapacityTest;
                upperCapacityBound = middleCapacityTest - 1; // Try to find a smaller valid capacity
            } else {
                lowerCapacityBound = middleCapacityTest + 1; // Must increase capacity
            }
        }

        return optimalCapacityFound;
    }

    private static boolean canShipPackagesWithinDays(int[] weights, int targetDays, int maximumCapacityPerDay) {
        int daysRequired = 1;
        int currentWeightOnShip = 0;

        for (int weight : weights) {
            if (currentWeightOnShip + weight > maximumCapacityPerDay) {
                daysRequired++;
                currentWeightOnShip = weight;
            } else {
                currentWeightOnShip += weight;
            }
        }
        return daysRequired <= targetDays;
    }
}