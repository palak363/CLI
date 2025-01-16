import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Details {  //INHERITANCE
    //ENCAPSULATION
    private int semester;
    private List<Course> enrolledCourses;
    private List<Course> completedCourses;
    private List<Double> sgpaList;
    private double cgpa;
    private String contactDetails;
    Scanner scanner = new Scanner(System.in);

    public Student(String email, String password, int semester) {
        super(email, password);
        this.semester = semester;
        this.enrolledCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.sgpaList = new ArrayList<>();
        this.cgpa = 0.0;
        this.contactDetails="";
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int sem){
        this.semester= sem;
    }

    public double getCGPA() {
        return this.cgpa;
    }

    public void setCGPA(double cgpa){
        this.cgpa = cgpa ;
    }

    public List<Double> getSgpaList() {
        return sgpaList;
    }

    public void addSgpgaList(double sgpa ){
        this.sgpaList.add(sgpa);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> courses){
        this.enrolledCourses = courses;
    }

    public List<Course> getCompletedCourses() {
        return this.completedCourses;
    }

    public void setCompletedCourses(List<Course> courses){
        this.completedCourses = courses;
    }

    public void setContactDetails(String cont){
        this.contactDetails=cont;
    }

    public String getContactDetails(){
        return this.contactDetails;
    }

    public void displayMenu() {
        System.out.println("Choose :");
        System.out.println("1. View Available Courses");
        System.out.println("2. Register for Course");
        System.out.println("3. View Schedule");
        System.out.println("4. Track Academic Progress");
        System.out.println("5. Drop Course");
        System.out.println("6. Submit a Complaint");
        System.out.println("7. Give feedback");
        System.out.println("8. Logout");
        int choice= scanner.nextInt();

        switch (choice) {
            case 1:
                this.viewCourses(this.getSemester());
                break;
            case 2:
                this.registerCourse();
                break;
            case 3:
                this.viewSchedule();
                break;
            case 4:
                this.academicProgress();
                break;
            case 5:
                this.dropCourse();
                break;
            case 6:
                this.complaints();
                break;
            case 7:
                this.giveFeedback();
                break;
            case 8:
                System.out.println("Logged out");
                login();
            default:
                System.out.println("Invalid choice. Please try again.");
        }displayMenu();
    }

    public void viewCourses(int semester) {
        List<Course> c_catalog = Catalog.getSemesterCourses(semester);
        int i=1;
        System.out.println("Your courses for semester " + semester + " are:");
        for (Course course : c_catalog) {
            Professor prof = course.getProfessor();
            System.out.println(i++ + ". Course Code: " + course.getCourseCode() +
                    ", Course Title: " + course.getTitle() +
                    ", Credits: " + course.getCredits() +
                    ", Pre-requisite: " + course.getPrerequisites() +
                    ", Professor: " + prof.getProfesssorName());
        }
    }

    public void registerCourse() {
        int totalCredits = 0;
        for (Course course : enrolledCourses) {
            totalCredits += course.getCredits();
        }
        List<Course> availableCourses = Catalog.getSemesterCourses(this.getSemester());
        this.viewCourses(this.getSemester());

        while (totalCredits < 20) {
            System.out.println("Enter the course number to register:");
            int courseNumber = scanner.nextInt();
            if (courseNumber > 0 && courseNumber <= availableCourses.size()) {
                Course selectedCourse = availableCourses.get(courseNumber - 1);
                if (enrolledCourses.contains(selectedCourse)) {
                    System.out.println("You are already registered for this course ");
                    continue;
                }

                int courseCredits = selectedCourse.getCredits();
                if (totalCredits + courseCredits > 20) {
                    System.out.println("Cannot register for this course.Credit limit reached");
                    break;
                }

                try{
                    if (selectedCourse.getPrerequisites().equals("NONE") || selectedCourse.getPrerequisites().isEmpty()) {
                        enrolledCourses.add(selectedCourse);
                        totalCredits += courseCredits;
                        selectedCourse.increaseCurrentEnrollment();
                        System.out.println("You have successfully registered " );
                    } else {
                        if (checkPrerequisites(selectedCourse.getPrerequisites())) {
                            enrolledCourses.add(selectedCourse);
                            totalCredits += courseCredits;
                            selectedCourse.increaseCurrentEnrollment();
                            System.out.println("You have successfully registered ");
                        } else {
                            System.out.println("You cannot register for this course. Prerequisite not completed: ");
                        }
                    }
                }catch (CourseFullException e){
                    System.out.println(e.getMessage());
                }

                if (totalCredits == 20) {
                    System.out.println("You have registered for the credit limit of 20 credits.");
                    break;
                }

            } else {
                System.out.println("Invalid course selection.");
            }

            System.out.println("Do you want to register for another course? (yes/no)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("Total registered credits: " + totalCredits);
        System.out.println("Registration complete.");
    }

    public boolean checkPrerequisites(String prerequisiteCourseCode) {
        for (Course completedCourse : this.getCompletedCourses()) {
            if (completedCourse.getCourseCode().equals(prerequisiteCourseCode)) {
                return true;
            }
        }
        return false;
    }

    public void viewSchedule() {
        int sem = this.getSemester();
        if(!enrolledCourses.isEmpty()) {
            for (Course c : enrolledCourses) {
                Professor p = c.getProfessor();
                System.out.println("Course code: " + c.getCourseCode() + " | " + "Course Title: " + c.getTitle() + " | " + " Schedule: " + c.getClassSchedule() + " | " + "Location: " + "LHC-101" + " | " + "Professor: " + p.getProfesssorName());
            }
        }else{
            System.out.println("You have no registered courses, so can't display schedule");
        }
    }

    public void academicProgress() {
        if (completedCourses.isEmpty()) {
            System.out.println("No completed courses to show academic progress.");
            return;
        }

        System.out.println("Completed Courses and Grades:");
        int totalCredits = 0;

        for (Course course : completedCourses) {
            int credits = course.getCredits();
            int grade = course.getGrade();

            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Credits: " + credits);
            System.out.println("GPA: " + grade);
            System.out.println("------------------------");
        }

        if (!sgpaList.isEmpty()) {
            int i=1;
            for(double s: sgpaList){
                System.out.println("SGPA for semester-"+ i++ +" is : "+ s);
            }
            System.out.println("CGPA: " + this.getCGPA());
        } else {
            System.out.println("No semester completed to calculate SGPA.");
        }
    }

    public void dropCourse() {
        System.out.println("Enter course code to drop:");
        scanner.nextLine();
        String course_code = scanner.nextLine();
        Course courseToRemove = null;
        for (Course enrolledCourse : this.enrolledCourses) {
            if (enrolledCourse.getCourseCode().equals(course_code)) {
                courseToRemove = enrolledCourse;
                break;
            }
        }

        if (courseToRemove != null) {
            try {
                int sem = this.getSemester();
                int dropDate = 1;
                int dropMonth = 7;
                int dropYear = 2024;
                if(sem == 1 || sem == 3 || sem == 5 || sem == 7){
                    dropDate = 31;
                }else{
                    dropDate = 31;
                    dropMonth = 1;
                }
                System.out.println("Enter date (1 - 30/31) :");
                int date = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter month (1 - 12) :");
                int month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter year (20xx) :");
                int year = scanner.nextInt();
                scanner.nextLine();

                if (month>dropMonth ) {
                    throw new DropDeadlinePassedException("DropDeadlinePassedException : Cannot drop the course. Drop deadline has passed.");
                }
                this.enrolledCourses.remove(courseToRemove);
                System.out.println("Course dropped successfully.");
            } catch (DropDeadlinePassedException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Course not found in enrolled courses.");
        }
    }

    public void complaints() {
        System.out.println("Enter your Complaint:");
        scanner.nextLine();
        String complaint = scanner.nextLine();
        Complaints c = new Complaints ("PENDING",complaint);
        Administrator.addComplaintList(c);
        System.out.println("Complaint submitted successfully!");
    }

    public <T> void giveFeedback() {
        if (this.getCompletedCourses().isEmpty()) {
            System.out.println("No courses completed");
        } else {
            System.out.println("Enter Course code for which you want to submit feedback:");
            scanner.nextLine();
            String courseCode = scanner.nextLine();

            Course courseToGiveFeedback = null;
            for (Course c : this.getCompletedCourses()) {
                if (c.getCourseCode().equals(courseCode)) {
                    courseToGiveFeedback = c;
                    break;
                }
            }

            if (courseToGiveFeedback != null) {
                System.out.println("What would you like to give: 1. Feedback 2. Rating");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter feedback:");
                        String feedbackContent = scanner.nextLine();
                        Feedback<String> feedback = new Feedback<>(feedbackContent);
                        courseToGiveFeedback.addFeedback(feedback);
                        System.out.println("Feedback submitted successfully!");
                        break;
                    case 2:
                        System.out.println("Enter Rating (1-5):");
                        int rate = scanner.nextInt();
                        scanner.nextLine();
                        Feedback<Integer> ratingFeedback = new Feedback<>(rate);
                        courseToGiveFeedback.addFeedback(ratingFeedback);
                        System.out.println("Rating submitted successfully!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Course not completed");
            }
        }
    }

}
