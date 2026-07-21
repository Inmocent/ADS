import java.util.ArrayList;
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Assignment2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


         System.out.println("Task 1  ");
         task1(sc);
         System.out.println("Task 2 ");
         task2(sc);
         System.out.println("Task 3");
         task3(sc);
         System.out.println("Task 4");
         task4(sc);
         System.out.println("Task 5 ");
         task5(sc);

        sc.close();
    }

    // t1
    public static void task1(Scanner sc) {
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(sc.nextInt());
            }
            lines.add(line);
        }


        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                System.out.println(lines.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
    }

    // t2
    public static void task2(Scanner sc) {
        int n = sc.nextInt();
        ArrayList<Integer> L = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            L.add(sc.nextInt());
        }


        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String queryType = sc.next();
            if (queryType.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                L.add(x, y);
            } else if (queryType.equals("Delete")) {
                int x = sc.nextInt();
                L.remove(x);
            }
        }


        for (int num : L) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // t3
    public static void task3(Scanner sc) {
        int operations = sc.nextInt();
        Deque<Integer> shelf = new LinkedList<>();

        for (int i = 0; i < operations; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                shelf.addFirst(sc.nextInt());
            } else if (type == 2) {
                shelf.addLast(sc.nextInt());
            } else if (type == 3) {
                System.out.print(shelf.removeFirst() + " ");
            } else if (type == 4) {
                System.out.print(shelf.removeLast() + " ");
            }
        }
        System.out.println();
    }

    // t4
    public static void task4(Scanner sc) {
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        reverseStack(stack);

        //sout  reversed stack elements
        for (int val : stack) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    //  method to reverse stack recursively
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    //  method to insert an element at the bottom
    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, item);
        stack.push(temp);
    }

    // t5
    public static void task5(Scanner sc) {
        int n = sc.nextInt();
        Queue<Integer> students = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            students.add(sc.nextInt());
        }

        Stack<Integer> samsas = new Stack<>();
        int[] samsaArr = new int[n];
        for (int i = 0; i < n; i++) {
            samsaArr[i] = sc.nextInt();
        }
        //push
        for (int i = n - 1; i >= 0; i--) {
            samsas.push(samsaArr[i]);
        }

        int attempts = 0;

        while (!students.isEmpty() && attempts < students.size()) {
            if (students.peek().equals(samsas.peek())) {
                students.poll();
                samsas.pop();
                attempts = 0;    // reset attempts when queue changes
            } else {
                students.add(students.poll()); // push back to queue
                attempts++;
            }
        }

        System.out.println(students.size()); // num of stud unable to eat
    }
}