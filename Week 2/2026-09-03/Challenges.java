
import static java.lang.System.*;
import java.util.*;

class Challenges {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        repl(scan);
        passwordValidator(scan);
        wordAnalyzer(scan);
        scan.close();
    }

    private static void repl(Scanner scan) {
        out.println("Welcome to my REPL App!");
        String command = "";

        while (!command.equals("quit")) {
            out.print("\n> ");
            command = scan.nextLine();

            if (command.equals("help")) {
                out.println();
                out.println("Available commands:");
                out.println(" add");
                out.println(" subtract");
                out.println(" multiply");
                out.println(" divide");
                out.println(" random");
                out.println(" reverse");
                out.println(" quit");
            } else if (command.equals("add")) {
                out.print("First number: ");
                double num1 = scan.nextDouble();
                out.print("Second number: ");
                double num2 = scan.nextDouble();
                out.println("Result: " + (num1 + num2));
                scan.nextLine();
            } else if (command.equals("subtract")) {
                out.print("First number: ");
                double num1 = scan.nextDouble();
                out.print("Second number: ");
                double num2 = scan.nextDouble();
                out.println("Result: " + (num1 - num2));
                scan.nextLine();
            } else if (command.equals("multiply")) {
                out.print("First number: ");
                double num1 = scan.nextDouble();
                out.print("Second number: ");
                double num2 = scan.nextDouble();
                out.println("Result: " + (num1 * num2));
                scan.nextLine();
            } else if (command.equals("divide")) {
                out.print("First number: ");
                double num1 = scan.nextDouble();
                out.print("Second number: ");
                double num2 = scan.nextDouble();
                out.println("Result: " + (num1 / num2));
                scan.nextLine();
            } else if (command.equals("random")) {
                out.print("Minimum: ");
                int min = scan.nextInt();
                out.print("Maximum: ");
                int max = scan.nextInt();
                int random = (int) (Math.random() * (max - min + 1)) + min;
                out.println("Random number: " + random);
                scan.nextLine();
            } else if (command.equals("reverse")) {
                out.print("Enter text: ");
                String text = scan.nextLine();
                for (int i = text.length() - 1; i >= 0; i--) {
                    out.print(text.charAt(i));
                }
                out.println();
            }
        }

        out.println("Goodbye!");
    }

    private static ArrayList<String> getPasswordErrors(String password) {
        var errors = new ArrayList<String>();

        if (password.length() < 8)
            errors.add("Password must be at least 8 characters.");

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                hasUppercase = true;
            else if (Character.isLowerCase(c))
                hasLowercase = true;
            else if (Character.isDigit(c))
                hasNumber = true;
        }

        if (!hasUppercase)
            errors.add("Must contain an uppercase letter.");
        if (!hasLowercase)
            errors.add("Must contain a lowercase letter.");
        if (!hasNumber)
            errors.add("Must contain a number.");

        return errors;
    }

    private static void passwordValidator(Scanner scan) {
        while (true) {
            out.print("Enter a password: ");
            String password = scan.nextLine();

            if (getPasswordErrors(password).isEmpty()) {
                out.println("Password accepted!");
                break;
            } else {
                out.println("Password rejected:");
                for (String error : getPasswordErrors(password)) {
                    out.println("- " + error);
                }
            }
        }
    }

    private static void wordAnalyzer(Scanner scan) {
        out.print("Enter a word: ");
        String word = scan.nextLine();

        int characters = word.length();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiouAEIOU".indexOf(c) != -1)
                    vowels++;
                else
                    consonants++;
            } else if (Character.isDigit(c))
                digits++;
            else if (Character.isWhitespace(c))
                spaces++;
        }

        out.println("Characters: " + characters);
        out.println("Vowels: " + vowels);
        out.println("Consonants: " + consonants);
        out.println("Digits: " + digits);
        out.println("Spaces: " + spaces);
    }
}