public class Challenges {
    public static void main(String[] args) {
        helloWorld();
        printingOutput();
        operators();
        controlFlow();
        loops();
        calculator();
    }

    private static void helloWorld() {
        System.out.println("Hello World!");
    }

    private static void printingOutput() {
        int age = 23;
        double height = 5 + 9.0 / 12.0;
        String name = "Thomas";
        System.out.printf("Name: %s, Age: %d, Height: %.1f %n", name, age, height);
    }

    private static void operators() {
        int a = 20, b = 10;
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Is a greater than b?" + (a > b));
        System.out.println("Is a > b and b > 0? " + (a > b && b > 0));
    }

    private static void controlFlow() {
        int score = 75;
        // char grade = 'B';

        if (score >= 50) {
            System.out.println("Passed");
            if (score >= 90) {
                System.out.println("Grade: A");
            } else if (score >= 75) {
                System.out.println("Grade: B");
            } else if (score >= 60) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: D");
            }
        } else {
            System.out.println("Failed");
        }
    }

    private static void loops() {
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= 5);
    }

    private static void calculator() {
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";

        while (again.equals("y")) {
            if (operator == '+') {
                System.out.println("Result: " + (num1 + num2));
            } else if (operator == '-') {
                System.out.println("Result: " + (num1 - num2));
            } else if (operator == '*') {
                System.out.println("Result: " + (num1 * num2));
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    System.out.println("Result: " + (num1 / num2));
                }
            }
            again = "n";
        }

        System.out.println("Thank you for using the calculator.");
    }
}
