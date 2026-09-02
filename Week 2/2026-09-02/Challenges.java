import java.util.Scanner;

public class Challenges {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        calculateTestScores(scan);
        repl(scan);
        scan.close();
    }

    private static void calculateTestScores(Scanner scan) {
        double scores[] = new double[5];

        System.out.println("Enter 5 test scores: ");

        for (int i = 0; i < scores.length; i++) {
            scores[i] = scan.nextDouble();
        }

        double total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        double average = total / scores.length;

        double highest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }

        double lowest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        System.out.println("Your values were:");

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 90) {
                System.out.println(scores[i] + " - A");
            } else if (scores[i] >= 80) {
                System.out.println(scores[i] + " - B");
            } else if (scores[i] >= 70) {
                System.out.println(scores[i] + " - C");
            } else if (scores[i] >= 60) {
                System.out.println(scores[i] + " - D");
            } else {
                System.out.println(scores[i] + " - F");
            }
        }
    }

    private static void repl(Scanner scan) {
        double balance = 0;

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = scan.nextInt();

            if (choice == 1) {
                System.out.println("Balance: " + balance);
            } else if (choice == 2) {
                System.out.println("Deposit amount: ");
                double deposit = scan.nextDouble();
                balance += deposit;
            } else if (choice == 3) {
                System.out.println("Withdraw amount: ");
                double withdraw = scan.nextDouble();
                balance -= withdraw;
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

}
