import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner; // 1. Fixed import statement

public class Practice3 {

    // 2. Added 'static' so our static methods can instantiate patients
    static class Patient {
        String name;
        int severity;

        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }

    // 3. Properly declared and initialized the Scanner
    static Scanner scanner = new Scanner(System.in);

    static Queue<Patient> waitingQueue = new LinkedList<>();

    static PriorityQueue<Patient> doctorQueue =
            new PriorityQueue<>((a, b) -> b.severity - a.severity);

    // Add patient
    static void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.next();

        System.out.print("Enter severity (1-10): ");
        int severity = scanner.nextInt();

        waitingQueue.add(new Patient(name, severity));

        System.out.println("Patient " + name + " added to waiting queue.\n");
    }

    // Move patient from waiting list to doctor's queue
    static void moveToDoctorQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue is empty.\n");
            return;
        }

        Patient p = waitingQueue.poll();
        doctorQueue.add(p);

        System.out.println(p.name + " moved to doctor queue.\n");
    }

    // Treat the highest severity patient in the doctor's queue
    static void treatPatient() {
        if (doctorQueue.isEmpty()) {
            System.out.println("No patients ready for treatment.\n");
            return;
        }

        Patient p = doctorQueue.poll();

        System.out.println("Doctor is treating: " + p.name +
                " (severity: " + p.severity + ")\n");
    }

    // Display the regular FIFO waiting queue
    static void showWaitingQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue is empty.\n");
            return;
        }

        System.out.println("--- Waiting Queue ---");
        for (Patient p : waitingQueue) {
            System.out.println(p.name + " (severity " + p.severity + ")");
        }
        System.out.println();
    }

    // Added support for Option 5: Show doctor's Priority Queue
    static void showDoctorQueue() {
        if (doctorQueue.isEmpty()) {
            System.out.println("Doctor queue is empty.\n");
            return;
        }

        System.out.println("--- Doctor's Priority Queue (Highest Severity First) ---");
        // Note: Iterating over a PriorityQueue does not guarantee sorted order.
        // To show them in true priority sequence without destroying the queue, we can copy it:
        PriorityQueue<Patient> tempQueue = new PriorityQueue<>(doctorQueue);
        while (!tempQueue.isEmpty()) {
            Patient p = tempQueue.poll();
            System.out.println(p.name + " (severity " + p.severity + ")");
        }
        System.out.println();
    }

    // 4. Wrapped your program menu and loop inside the main method!
    public static void main(String[] args) {
        while (true) {
            System.out.println("====== EMERGENCY ROOM SYSTEM ======");
            System.out.println("1 - Add patient");
            System.out.println("2 - Move patient to doctor queue");
            System.out.println("3 - Treat patient");
            System.out.println("4 - Show waiting queue");
            System.out.println("5 - Show doctor queue");
            System.out.println("0 - Exit");
            System.out.print("Choose command: ");

            int command = scanner.nextInt();

            if (command == 1) {
                addPatient();
            } else if (command == 2) {
                moveToDoctorQueue();
            } else if (command == 3) {
                treatPatient();
            } else if (command == 4) {
                showWaitingQueue();
            } else if (command == 5) {
                showDoctorQueue();
            } else if (command == 0) {
                System.out.println("Exiting Emergency Room System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid command. Please try again.\n");
            }
        }

        scanner.close(); // Clean up resource
    }
}