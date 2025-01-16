import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TA extends Student{
    private String courseCodeTA;
    Scanner scanner = new Scanner(System.in);

    public String getCourseCodeTA() {
        return courseCodeTA;
    }

    public void setCourseCodeTA(String courseCodeTA) {
        this.courseCodeTA = courseCodeTA;
    }

    public TA(String email, String password, int semester , String course) {
        super(email, password, semester);
        this.courseCodeTA = course;
    }

    public void displayMenu() {
        System.out.println("");
        System.out.println("TA Menu : ");
        System.out.println("1. View student grades");
        System.out.println("2. Update student grades");

        System.out.println("");
        System.out.println("Student Menu");
        System.out.println("3. View Available Courses");
        System.out.println("4. Register for Course");
        System.out.println("5. View Schedule");
        System.out.println("6. Track Academic Progress");
        System.out.println("7. Drop Course");
        System.out.println("8. Submit a Complaint");
        System.out.println("9. Give feedback");

        System.out.println("10. Logout");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                this.viewStudentGrades();
                break;
            case 2:
                this.updateStudentGrade();
                break;
            case 3:
                this.viewCourses(this.getSemester());
                break;
            case 4:
                this.registerCourse();
                break;
            case 5:
                this.viewSchedule();
                break;
            case 6:
                this.academicProgress();
                break;
            case 7:
                this.dropCourse();
                break;
            case 8:
                this.complaints();
                break;
            case 9:
                this.giveFeedback();
                break;
            case 10:
                System.out.println("Logged out");
                login();
            default:
                System.out.println("Invalid choice. Please try again.");
        }this.displayMenu();
    }

    private void viewStudentGrades() {
        System.out.println("Enter student email to view records:");
        String email = scanner.nextLine();
        Student student = Details.findStudentByEmail(email);

        if (student != null) {
            Course course = findCourseInCompleted(student);
            if (course != null) {
                System.out.println("Student's grade: " + course.getGrade());
            } else {
                System.out.println("Student has not completed the course.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private void updateStudentGrade() {
        System.out.println("Enter student email to update records:");
        String email = scanner.nextLine();
        Student student = Details.findStudentByEmail(email);

        if (student != null) {
            Course course = findCourseInCompleted(student);
            if (course != null) {
                System.out.println("Enter grade for course " + course.getTitle() + " (" + course.getCourseCode() + ")");
                int grade = scanner.nextInt();
                scanner.nextLine();
                course.setGrade(grade);
                System.out.println("Grade updated successfully.");

                int sgpaTotalGrade = 0;
                int sgpaCount =0;
                for(Course c : student.getCompletedCourses()){
                    sgpaTotalGrade+=(c.getGrade() * c.getCredits());
                    sgpaCount+=c.getCredits();
                }
                int semesterIndex = student.getSemester() - 2;
                student.getSgpaList().set(semesterIndex, (double) sgpaTotalGrade / sgpaCount);

                int cgpaTotalGrade = 0;
                int cgpaCount =0;
                for(Course c: student.getCompletedCourses()){
                    cgpaTotalGrade+=(c.getGrade() * c.getCredits());
                    cgpaCount+=c.getCredits();
                }
                student.setCGPA((double) cgpaTotalGrade /cgpaCount);


            } else {
                System.out.println("Student has not completed the course.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private Course findCourseInCompleted(Student student) {
        List<Course> completedCourses = student.getCompletedCourses();
        for (Course c : completedCourses) {
            if (c.getCourseCode().equals(courseCodeTA)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "TA email: " + getEmail() + ", Course assigned: " + courseCodeTA;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TA ta = (TA) obj;
        return (this.getEmail().equals(ta.getEmail()) && this.courseCodeTA.equals(ta.courseCodeTA));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
