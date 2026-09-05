import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        Month currentMonth = today.getMonth();
        int currentDayOfMonth = today.getDayOfMonth();

        System.out.println("Date: " + today);
        System.out.println("Year: " + currentYear);
        System.out.println("Month: " + currentMonth);
        System.out.println("Day: " + currentDayOfMonth);

        System.out.print("Enter your birth date: ");
        Scanner scan = new Scanner(System.in);

        String birthDateString = scan.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateString);
        Period agePeriod = Period.between(birthDate, today);
        int age = agePeriod.getYears();
        System.out.printf("You are %d years old.%n", age);

        LocalDate nextBirthday = birthDate.withYear(currentYear);
        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        long daysUntilBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("Days Until Next Birthday: " + daysUntilBirthday);

        scan.close();
    }
}