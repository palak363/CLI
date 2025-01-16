import java.util.Scanner;

public abstract class Details implements User {
    protected String email;
    protected String password;
    static Scanner scanner = new Scanner(System.in);

    public Details(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static void login() {
        System.out.println("Login as:");
        System.out.println("1. Student");
        System.out.println("2. Professor");
        System.out.println("3. Administrator");
        System.out.println("4. Teaching Assistant");
        System.out.println("5. OR Sign up");
        System.out.println("6. Exit the Application");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: // Student login
                try {
                    handleStudentLogin();
                } catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                    login();
                }
                break;

            case 2: // Professor login
                try {
                    handleProfessorLogin();
                } catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                    login();
                }
                break;

            case 3: // Admin login
                try {
                    handleAdminLogin();
                } catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                    login();
                }
                break;

            case 4: // TA login
                try {
                    handleTALogin();
                } catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                    login();
                }
                break;

            case 5: // Sign up
                handleSignUp();
                break;

            case 6:
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void handleStudentLogin() throws InvalidLoginException {
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        Student student = findStudentByEmail(email);
        if (student != null && password.equals(student.getPassword())) {
            student.displayMenu();
        } else {
            throw new InvalidLoginException("InvalidLoginException : Invalid email or password for Student.");
        }
    }

    private static void handleProfessorLogin() throws InvalidLoginException {
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        Professor professor = findProfessorByEmail(email);
        if (professor != null && password.equals(professor.getPassword())) {
            professor.displayMenu();
        } else {
            throw new InvalidLoginException("InvalidLoginException : Invalid email or password for Professor.");
        }
    }

    private static void handleAdminLogin() throws InvalidLoginException {
        Administrator admin = new Administrator("admin@iiitd.ac.in", "admin");
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (email.equals(admin.getEmail()) && password.equals(admin.getPassword())) {
            admin.displayMenu();
        } else {
            throw new InvalidLoginException("InvalidLoginException : Invalid email or password for Administrator.");
        }
    }

    private static void handleTALogin() throws InvalidLoginException {
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        TA ta = findTAByEmail(email);
        if (ta != null && password.equals(ta.getPassword())) {
            ta.displayMenu();
        } else {
            throw new InvalidLoginException("InvalidLoginException : Invalid email or password for Teaching Assistant.");
        }
    }

    private static void handleSignUp() {
        System.out.println("Sign up as:");
        System.out.println("1. Student");
        System.out.println("2. Professor");
        System.out.println("3. Teaching Assistant");
        int signupChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your email:");
        String newEmail = scanner.nextLine();
        System.out.println("Enter your password:");
        String newPassword = scanner.nextLine();
        System.out.println("Enter your contact details:");
        String contact_details = scanner.nextLine();

        if (signupChoice == 1) {
            Student newStudent = new Student(newEmail, newPassword, 1);
            newStudent.setContactDetails(contact_details);
            Administrator.addStudent(newStudent);
            System.out.println("Student account created successfully!");
            login();
        } else if (signupChoice == 2) {
            Professor newProf = new Professor(newEmail, newPassword);
            Administrator.addProfessor(newProf);
            System.out.println("Professor account created successfully!");
            login();
        } else if (signupChoice == 3) {
            System.out.println("Enter course code assigned:");
            String course = scanner.nextLine();
            TA newTA = new TA(newEmail, newPassword, 1, course);
            Administrator.addTAList(newTA);
            System.out.println("TA account created successfully!");
            login();
        } else {
            System.out.println("Invalid choice for signup.");
        }
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static Student findStudentByEmail(String email) {
        for (Student student : Administrator.getStudentRecords()) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    public static Professor findProfessorByEmail(String email) {
        for (Professor professor : Administrator.getProfessorRecords()) {
            if (professor.getEmail().equals(email)) {
                return professor;
            }
        }
        return null;
    }

    public static TA findTAByEmail(String email) {
        for (TA ta : Administrator.getTAList()) {
            if (ta.getEmail().equals(email)) {
                return ta;
            }
        }
        return null;
    }
}
