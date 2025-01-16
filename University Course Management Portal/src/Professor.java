import java.util.*;

public class Professor extends Details {
    private String ProfessorName;
    private List<Course> assignedCourses = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Professor(String email, String password) {
        super(email, password);
    }

    public void setProfessorName(String professorname) {
        ProfessorName = professorname;
    }

    public String getProfesssorName(){
        return this.password;
    }

    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(List<Course> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public void addAssignedCourses(Course c){
        assignedCourses.add(c);
    }

    //OVERLOADING
    public void addAssignedCourses(String code){
        Course c = findCourseByCode(code);
        assignedCourses.add(c);
    }

    public void displayMenu() {
        start();
        System.out.println("Professor Menu : ");
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. View feedback");
        System.out.println("4. Logout");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                this.manageCourses();
                break;
            case 2:
                this.viewEnrolledStudents();
                break;
            case 3:
                this.viewCourseFeedback();
                break;
            case 4:
                System.out.println("Logged out");
                login();
            default:
                System.out.println("Invalid choice. Please try again.");
        }this.displayMenu();
    }

    public void start() {
        List<Course> courses = Administrator.getCourseCatalog();
        for (Course c : courses) {
            Professor professor = c.getProfessor();
            if (professor != null && professor.getEmail().equals(this.getEmail())) {
                if (!this.getAssignedCourses().contains(c)) {
                    this.addAssignedCourses(c);
                }
            }
        }
    }

    public void manageCourses() {
        while (true) {
            System.out.println("Manage Courses:");
            System.out.println("1. View Course Details");
            System.out.println("2. Update Course Details");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewCourseDetails();
                    break;
                case 2:
                    updateCourseDetails();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewCourseDetails() {
        if(!assignedCourses.isEmpty()){
            System.out.println("COURSE LIST:");
            for (Course course: assignedCourses){
                System.out.println("Course Code: " + course.getCourseCode() +
                        ", Course Title: " + course.getTitle() +
                        ", Credits: " + course.getCredits() +
                        ", Pre-requisite: " + course.getPrerequisites());
            }
            System.out.println("Enter course code to view details:");
            String courseCode = scanner.nextLine();
            Course course = findCourseByCode(courseCode);

            if (course != null) {
                Professor p = course.getProfessor();
                System.out.println("Course Code: " + course.getCourseCode());
                System.out.println("Title: " + course.getTitle());
                System.out.println("Credits: " + course.getCredits());
                System.out.println("Prerequisites: " + course.getPrerequisites());
                System.out.println("Professor: " + p.getEmail());
                System.out.println("Syllabus: " + course.getSyllabus());
                System.out.println("Class schedule: " + course.getClassSchedule());
                System.out.println("Enrollment Limits: " + course.getEnrollmentLimits());
                System.out.println("Office Hours: " + course.getOfficeHours());
            } else {
                System.out.println("Course not found.");
            }
        }else System.out.println("No course assigned ");
    }

    private void updateCourseDetails() {
        for (Course course: assignedCourses){
            System.out.println("Course Code: " + course.getCourseCode() +
                    ", Course Title: " + course.getTitle() +
                    ", Credits: " + course.getCredits() +
                    ", Pre-requisite: " + course.getPrerequisites());
        }
        System.out.println("Enter course code to update details:");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);

        if (course != null) {
            System.out.println("Update Course Details:");
            System.out.println("1. Update Syllabus");
            System.out.println("2. Update Class Schedule");
            System.out.println("3. Update Credits");
            System.out.println("4. Update Prerequisites");
            System.out.println("5. Update Enrollment Limits");
            System.out.println("6. Update Office Hours");
            System.out.println("7. Go Back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter syllabus:");
                    String syllabus = scanner.nextLine();
                    course.setSyllabus(syllabus);
                    System.out.println("Syllabus updated successfully.");
                    break;
                case 2:
                    System.out.println("Enter class schedule:");
                    String class_schedule = scanner.nextLine();
                    course.setClassSchedule(class_schedule);
                    System.out.println("Class Schedule updated successfully.");
                    break;
                case 3:
                    System.out.println("Enter credits: 2 or 4");
                    int credits = scanner.nextInt();
                    scanner.nextLine();
                    course.setCredits(credits);
                    System.out.println("Credits updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter prerequisite:");
                    String p = scanner.nextLine();
                    course.setPrerequisites(p);
                    System.out.println("Prerequisites updated successfully.");
                    break;
                case 5:
                    System.out.println("Enter enrollment limits:");
                    int enrollmentLimits = scanner.nextInt();
                    scanner.nextLine();
                    course.setEnrollmentLimits(enrollmentLimits);
                    System.out.println("Enrollment limits updated successfully.");
                    break;
                case 6:
                    System.out.println("Enter office hours:");
                    String officeHours = scanner.nextLine();
                    course.setOfficeHours(officeHours);
                    System.out.println("Office hours updated successfully.");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    private Course findCourseByCode(String courseCode) {
        for (Course course : assignedCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public void viewEnrolledStudents() {
        for(Course assigned : assignedCourses){
            System.out.println("Course: " + assigned.getTitle() + " (" + assigned.getCourseCode() + ")");
            List<Student> stu = new ArrayList<>();
            for(Student s: Administrator.getStudentRecords()){
                for(Course c: s.getEnrolledCourses() ){
                    if (assigned.getCourseCode().equals(c.getCourseCode())){
                        if (!stu.contains(s)) {
                            stu.add(s);
                        }
                    }
                }
            }
            if(!stu.isEmpty()){
                for(Student student: stu){
                    System.out.println("Student Email: " + student.getEmail());
                    System.out.println("Academic Standing (CGPA): " + student.getCGPA());
                    System.out.println("Semester: " + student.getSemester());
                    System.out.println("Contact Details: " + student.getContactDetails());
                    System.out.println("-----------------------");
                }
            }else {
                System.out.println("No student enrolled");
                System.out.println("-----------------------");
            }

        }

    }

    public void viewCourseFeedback() {
        for (Course course : assignedCourses) {
            course.showFeedback();
        }
    }
}
