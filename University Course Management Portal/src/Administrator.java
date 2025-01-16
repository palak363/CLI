import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrator extends Details {
    //ENCAPSULATION
    Scanner scanner = new Scanner(System.in);
    private static List<Course> CourseCatalog = Catalog.courseCatalog();
    private static List<Student> studentRecords = new ArrayList<>();
    private static List<Professor> professorRecords = Catalog.professorCatalog();
    private static List<Complaints> ComplaintList = new ArrayList<>();
    private static List<TA> TAList = new ArrayList<>();

    public Administrator(String email, String password) {
        super(email, password);
        setEmail("admin@iiitd.ac.in");
        setPassword("admin");
    }

    public static List<Course> getCourseCatalog(){
        return CourseCatalog;
    }

    public static List<Student> getStudentRecords() {
        return studentRecords;
    }

    public static void setStudentRecords(List<Student> student) {
        studentRecords = student;
    }

    public static List<Complaints> getComplaintList() {
        return ComplaintList;
    }

    public static void setComplaintList(List<Complaints> complaintList) {
        ComplaintList = complaintList;
    }

    public static void addComplaintList(Complaints c) {
        ComplaintList.add(c);
    }

    public static void addTAList(TA ta) {
        TAList.add(ta);
    }

    public static List<TA> getTAList() {
        return TAList;
    }

    public static void setTAList(List<TA> TAList) {
        Administrator.TAList = TAList;
    }

    //OVERLOADING
    public static void addComplaintList(String description) {
        Complaints c = new Complaints("PENDING",description);
        ComplaintList.add(c);
    }

    public static List<Professor> getProfessorRecords() {
        return professorRecords;
    }

    public static void setProfessorRecords(List<Professor> professorRecords) {
        Administrator.professorRecords = professorRecords;
    }

    public void displayMenu() {
        System.out.println("Administrator Menu : ");
        System.out.println("1. Manage Course Catalog");
        System.out.println("2. Manage Student Records");
        System.out.println("3. Assign Professors to Courses");
        System.out.println("4. Handle Complaints");
        System.out.println("5. Logout");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                this.manageCourseCatalog();
                break;
            case 2:
                this.manageStudentRecords();
                break;
            case 3:
                this.assignProfessorsToCourses();
                break;
            case 4:
                this.handleComplaints();
                break;
            case 5:
                System.out.println("Logged out");
                login();
            default:
                System.out.println("Invalid choice. Please try again.");
        }displayMenu();

    }

    public void manageCourseCatalog() {
        int choice;
        do {
            System.out.println("Course Catalog Management:");
            System.out.println("1. View Courses");
            System.out.println("2. Add a Course");
            System.out.println("3. Delete a Course");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    addCourseToCatalog();
                    break;
                case 3:
                    deleteCourseFromCatalog();
                    break;
                case 4:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    private void viewCourses() {
        if (CourseCatalog.isEmpty()) {
            System.out.println("No courses in the catalog.");
        } else {
            System.out.println("Courses in the catalog:");
            for (Course course : CourseCatalog) {
                Professor p = course.getProfessor();
                System.out.println("Course Code: " + course.getCourseCode() +
                        ", Title: " + course.getTitle() +
                        ", Credits: " + course.getCredits() +
                        ", Professor email: " + p.getEmail());
            }
        }
    }

    private void addCourseToCatalog() {
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        System.out.println("Enter course title:");
        String courseTitle = scanner.nextLine();
        System.out.println("Enter course credits:");
        int courseCredits = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter professor email:");
        String email = scanner.nextLine();
        Professor professor = Catalog.getProfessor(email);
        if(Catalog.getProfessor(email) == null) {
            System.out.println("Professor not found");
        }else {
            System.out.println("Enter prerequisite course code:");
            String prerequisites = scanner.nextLine();

            Course newCourse = new Course(courseCode, courseTitle, courseCredits, prerequisites, professor);
            CourseCatalog.add(newCourse);
            System.out.println("Course added successfully.");
        }
    }

    private void deleteCourseFromCatalog() {
        System.out.println("Enter course code to delete:");
        String courseCode = scanner.nextLine();

        Course courseToRemove = null;
        for (Course course : CourseCatalog) {
            if (course.getCourseCode().equals(courseCode)) {
                courseToRemove = course;
                break;
            }
        }
        if (courseToRemove != null) {
            CourseCatalog.remove(courseToRemove);
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void manageStudentRecords() {
        int choice;
        do {
            System.out.println("Student Records Management:");
            System.out.println("1. View Student Records");
            System.out.println("2. Update Student Records");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStudentRecords();
                    break;
                case 2:
                    updateStudentRecords();
                    break;
                case 3:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    public void viewStudentRecords() {
        System.out.println("Enter student email to view records:");
        String email = scanner.nextLine();

        Student student = Details.findStudentByEmail(email);
        if (student != null) {
            List<Course> completedCourses = student.getCompletedCourses();
            List<Course> enrolledCourses = student.getEnrolledCourses();
            System.out.println("Student Email: " + student.getEmail());
            System.out.println("Semester: " + student.getSemester());
            System.out.println("Contact Details: " + student.getContactDetails());
            System.out.println("CGPA:"+ student.getCGPA());
            if(!enrolledCourses.isEmpty()) {
                System.out.println("Enrolled Courses: " );
                for(Course c: enrolledCourses) System.out.println("Course Title:" + c.getTitle() + " | " + "Course Code:" + c.getCourseCode());
            } else System.out.println("No enrolled courses");

            if(!completedCourses.isEmpty()){
                System.out.println("Completed Courses: " );
                for(Course c: completedCourses) System.out.println("Course Title:" + c.getTitle() + " | " + "Course Code:" + c.getCourseCode());
            }else System.out.println("No completed courses");

        } else {
            System.out.println("Student not found.");
        }
    }

    private void updateStudentRecords() {
        System.out.println("Enter student email to update records:");
        String email = scanner.nextLine();

        Student student = Details.findStudentByEmail(email);
        if (student != null) {
            System.out.println("Updating records for: " + student.getEmail());
            System.out.println("1. Update Personal Information");
            System.out.println("2. Update Grades");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    updatePersonalInformation(student);
                    break;
                case 2:
                    updateGrades(student);
                    break;
                case 3:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private void updatePersonalInformation(Student student) {
        System.out.println("What would you like to update?");
        System.out.println("1. Email");
        System.out.println("2. Password");
        System.out.println("3. Contact Details");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter new email ID:");
                String newEmail = scanner.nextLine();
                student.setEmail(newEmail);
                System.out.println("Email updated successfully.");
                break;
            case 2:
                System.out.println("Enter new password:");
                String newPassword = scanner.nextLine();
                student.setPassword(newPassword);
                System.out.println("Password updated successfully.");
                break;
            case 3:
                System.out.println("Enter new Contact Details:");
                String cont = scanner.nextLine();
                student.setContactDetails(cont);
                System.out.println("Contact details updated successfully.");
                break;
            case 4:
                System.out.println("Exited.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void updateGrades(Student student) {
        for(Course c : student.getEnrolledCourses()){
            System.out.println("Enter grade for course "+ c.getTitle() + "(" + c.getCourseCode() + ")");
            int grade = scanner.nextInt();
            scanner.nextLine();
            c.setGrade(grade);
            System.out.println("Grade updated successfully.");
            System.out.println("Pass/Fail Status: " + c.getPassFailStatus());
        }
        boolean pass= true;
        int sgpaTotalGrade = 0;
        int sgpaCount =0;
        for(Course c : student.getEnrolledCourses()){
            sgpaTotalGrade+=(c.getGrade() * c.getCredits());
            sgpaCount+=c.getCredits();
            if(c.getPassFailStatus() == "Failed") pass = false;

        }
        student.addSgpgaList((double) sgpaTotalGrade /sgpaCount);
        if(pass){
            student.setSemester(student.getSemester()+1);
            student.setCompletedCourses(student.getEnrolledCourses());
            student.setEnrolledCourses(new ArrayList<>());
            System.out.println("Promoted to next semester");
        }
        int cgpaTotalGrade = 0;
        int cgpaCount =0;
        for(Course c: student.getCompletedCourses()){
            cgpaTotalGrade+=(c.getGrade() * c.getCredits());
            cgpaCount+=c.getCredits();
        }
        student.setCGPA((double) cgpaTotalGrade /cgpaCount);

    }

    public void assignProfessorsToCourses() {
        System.out.println("Enter professor email to assign:");
        scanner.nextLine();
        String professorEmail = scanner.nextLine();
        Professor professor = Details.findProfessorByEmail(professorEmail);

        if (professor != null) {
            System.out.println("Enter course code to assign:");
            String courseCode = scanner.nextLine();
            Course course = findCourseByCode(courseCode);

            if (course != null) {
                course.setProfessor(professor);
                Catalog.setProfessor(professor,course);
                System.out.println("Professor assigned to course successfully.");
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Professor not found.");
        }
    }

    private Course findCourseByCode(String courseCode) {
        for (Course course : CourseCatalog) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void addStudent(Student student) {
        studentRecords.add(student);
    }

    public static void addProfessor(Professor professor) {
        professorRecords.add(professor);
    }

    public void handleComplaints() {
        List<Complaints> complaints = getComplaintList();
        int choice;
        do {
            System.out.println("Handle Complaints:");
            System.out.println("1. View complaints");
            System.out.println("2. Update status of a complaint");
            System.out.println("3. Filter complaints");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewComplaints(complaints);
                    break;
                case 2:
                    updateComplaintStatus(complaints);
                    break;
                case 3:
                    filterComplaints(complaints);
                    break;
                case 4:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    public void viewComplaints(List<Complaints> complaints) {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
        } else {
            System.out.println("Here are all the complaints:");
            int i = 1;
            for (Complaints c : complaints) {
                System.out.println(i++ + ". Description: " + c.getDescription() + ", STATUS: " + c.getStatus());
            }
        }
    }

    public void updateComplaintStatus(List<Complaints> complaints) {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found");
            return;
        }
        viewComplaints(complaints);
        System.out.println("Enter the number of the complaint to update status:");
        int complaintNumber = scanner.nextInt();
        scanner.nextLine();
        if (complaintNumber > 0 && complaintNumber <= complaints.size()) {
            Complaints complaint = complaints.get(complaintNumber - 1);
            System.out.println("Enter new status for the complaint: 1.PENDING  2.RESOLVED");
            int status = scanner.nextInt();
            switch(status){
                case 1:
                    complaint.setStatus("PENDING");
                    break;
                case 2:
                    complaint.setStatus("RESOLVED");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("Complaint status updated successfully.");
        } else {
            System.out.println("Invalid complaint number.");
        }
    }

    public void filterComplaints(List<Complaints> complaints){
        if (complaints.isEmpty()) {
            System.out.println("No complaints available to update.");
            return;
        }
        System.out.println("Choose:");
        System.out.println("1.View only PENDING complaints");
        System.out.println("2.View only RESOLVED complaints");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                for(Complaints c : complaints){
                    if (c.getStatus().equalsIgnoreCase("PENDING")) System.out.println("Description: " + c.getDescription() + ", STATUS: " + c.getStatus());
                }break;
            case 2:
                for(Complaints c : complaints){
                    if (c.getStatus().equalsIgnoreCase("RESOLVED")) System.out.println("Description: " + c.getDescription() + ", STATUS: " + c.getStatus());
                }break;
            default:
                System.out.println("Invalid option. Please try again.");
        }


    }
}
