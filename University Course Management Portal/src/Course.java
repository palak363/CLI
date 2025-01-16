import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    //ENCAPSULATION
    private String courseCode;
    private String title;
    private int credits;
    private String prerequisites;
    private Professor professor; //COMPOSITION
    private String syllabus = "Refer TechTree";
    private int enrollmentLimit = 300;
    private String officeHours = "Friday 6pm to 7pm";
    private String classSchedule;
    private int grade;
    private List<Student> enrolledStudents = new ArrayList<>();
    private List<Feedback<?>> feedbackList;
    private int currentEnrollment;

    public Course(String course_code, String title, int credits, String prerequisites,Professor professor) {
        this.courseCode = course_code;
        this.title = title;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.professor = professor;
        this.grade = 0;
        this.currentEnrollment = 0;
        this.feedbackList = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public void setCurrentEnrollment(int currentEnrollment) {
        this.currentEnrollment = currentEnrollment;
    }

    public void increaseCurrentEnrollment() throws CourseFullException {
        if (currentEnrollment >= getEnrollmentLimits()) {
            throw new CourseFullException("CourseFullException : Course is full. Maximum enrollment of reached.");
        }
        currentEnrollment++;
    }

    public void setCourseCode(String course_code) {
        this.courseCode = course_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public int getEnrollmentLimits() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimits(int enrollment_limit) {
        this.enrollmentLimit = enrollment_limit;
    }

    public String getClassSchedule() {
        return classSchedule;
    }

    public void setClassSchedule(String class_schedule) {
        this.classSchedule = class_schedule;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String office_hours) {
        this.officeHours = office_hours;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 10) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade. Please enter a grade between 1 and 10.");
        }
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getPassFailStatus() {
        if (grade>=4) {
            return "PASS";
        }
        else {
            return "FAIL";
        }
    }

    public <T> void addFeedback(T feedback) {
        feedbackList.add(new Feedback<>(feedback));
    }

    public List<Feedback<?>> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback<?>> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public void showFeedback() {
        System.out.println("Feedback for course: " + getTitle());
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            System.out.println("---------------------------------");
        } else {
            for (Feedback<?> feedback : feedbackList) {
                System.out.println("Course:" + getTitle());
                System.out.println("Feedback/Rating:"+ feedback.getFeedbackContent());
                System.out.println("---------------------------------");
            }
        }
    }
}
