import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int mailBoxCapacity;

    private String alternateEmail;
    private static final String COMPANY_SUFFIX = ".company.com";
    private static final int DEFAULT_MAILBOX_CAPACITY = 500;

    //Constructor to receive first name and last name
    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED : " + firstName + " " + lastName);

        // call method asking for department
        this.department = setDeparment();

        // call method that return a random password
        this.password = setPass();

        // combine elements to generate email
        this.email = generateEmail();

        //set mailBox capacity
        this.mailBoxCapacity = DEFAULT_MAILBOX_CAPACITY;



    }

    private String setDeparment (){
        System.out.println("Departments : \n1. Sales \n2. Development \n3. Accounting \n0. None");
        System.out.println("Enter department code :");
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()){
            System.out.println("Invalid input. Enter department code : ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        return switch (choice){
            case 1 -> "Sales";
            case 2 -> "Development";
            case 3 -> "Accounting";
            default -> "None";
        };
    }

    private String setPass(){
        String setPass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*?";
        char [] pass = new char[8];
        for (int i = 0; i < 8; i++) {
            int rand = (int) (Math.random() * setPass.length());
            pass [i] = setPass.charAt(rand);
        }
        return new String(pass);
    }
    public void changePass (String currentPass, String newPass){
        if (this.password.equals(currentPass)){
            if (newPass.matches(".*[A-Z].*") && newPass.matches(".*[a-z].*")
                && newPass.matches(".*\\d.*") && newPass.matches(".*[@#$%&*?].*")){
                this.password = newPass;
                System.out.println("Password successfully changed.");
            }else {
                System.out.println("Password does not meet strength requirements.");
            }
        } else {
            System.out.println("Current password is incorrect.");
        }
    }

    private String generateEmail (){
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + COMPANY_SUFFIX;
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // Get the mailbox capacity
    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public void setAlternateEmail(String altEmail) {
        if (altEmail.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            this.alternateEmail = altEmail;
        } else {
            System.out.println("Invalid email format. Alternate email not set.");
        }
    }


    // Get the alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nDEPARTMENT : " + department +
                "\nPASSWORD : " + password +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
