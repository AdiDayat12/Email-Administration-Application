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
        System.out.println("Deparments : \n1. Sales \n2. Development \n3. Accounting \n0. None");
        System.out.println("Enter department code :");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return switch (choice) {
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
    public void changePass (String newPass){
        this.password = newPass;
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
        this.alternateEmail = altEmail;
    }

    // Get the alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nPASSWORD : " + password +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
