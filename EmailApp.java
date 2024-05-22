import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter Last Name: ");
            String lastName = scanner.nextLine();
            Email email = new Email(firstName, lastName);
            System.out.println(email.showInfo());
        }
    }
}
