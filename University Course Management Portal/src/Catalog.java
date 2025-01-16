import java.util.ArrayList;
import java.util.List;

public class Catalog {
    static List<Course> c_catalog = new ArrayList<>();
    static List<Professor> p_catalog = new ArrayList<>();

    public static List<Course> courseCatalog() {

        Course s1_c1 = new Course("101", "A1", 4, "NONE", getProfessor("A@iiitd.ac.in"));
        s1_c1.setClassSchedule("Monday - 8am to 9am");
        Course s1_c2 = new Course("102", "B1", 4, "NONE", getProfessor("B@iiitd.ac.in"));
        s1_c2.setClassSchedule("Tuesday - 9am to 10am");
        Course s1_c3 = new Course("103", "C1", 4, "NONE", getProfessor("C@iiitd.ac.in"));
        s1_c3.setClassSchedule("Wednesday - 10am to 11am");
        Course s1_c4 = new Course("104", "D1", 4, "NONE", getProfessor("D@iiitd.ac.in"));
        s1_c4.setClassSchedule("Thursday - 11am to 12pm");
        Course s1_c5 = new Course("105", "E1", 4, "NONE", getProfessor("E@iiitd.ac.in"));
        s1_c5.setClassSchedule("Friday - 1pm to 2pm");
        Course s1_c6 = new Course("106", "F1", 2, "NONE", getProfessor("F@iiitd.ac.in"));
        s1_c6.setClassSchedule("Monday - 3pm to 4pm");
        Course s1_c7 = new Course("107", "G1", 2, "NONE", getProfessor("G@iiitd.ac.in"));
        s1_c7.setClassSchedule("Tuesday - 4pm to 5pm");
        Course[] s1 = {s1_c1, s1_c2, s1_c3, s1_c4, s1_c5, s1_c6, s1_c7};

        Course s2_c1 = new Course("201", "A2", 4, "101", getProfessor("A@iiitd.ac.in"));
        s2_c1.setClassSchedule("Tuesday - 9am to 10am");
        Course s2_c2 = new Course("202", "B2", 4, "102", getProfessor("B@iiitd.ac.in"));
        s2_c2.setClassSchedule("Wednesday - 10am to 11am");
        Course s2_c3 = new Course("203", "C2", 4, "103", getProfessor("C@iiitd.ac.in"));
        s2_c3.setClassSchedule("Thursday - 11am to 12pm");
        Course s2_c4 = new Course("204", "D2", 4, "104", getProfessor("D@iiitd.ac.in"));
        s2_c4.setClassSchedule("Friday - 1pm to 2pm");
        Course s2_c5 = new Course("205", "E2", 4, "105", getProfessor("E@iiitd.ac.in"));
        s2_c5.setClassSchedule("Monday - 2pm to 3pm");
        Course s2_c6 = new Course("206", "F2", 2, "106", getProfessor("F@iiitd.ac.in"));
        s2_c6.setClassSchedule("Tuesday - 3pm to 4pm");
        Course s2_c7 = new Course("207", "G2", 2, "107", getProfessor("G@iiitd.ac.in"));
        s2_c7.setClassSchedule("Wednesday - 4pm to 5pm");
        Course[] s2 = {s2_c1, s2_c2, s2_c3, s2_c4, s2_c5, s2_c6, s2_c7};

        Course s3_c1 = new Course("301", "A3", 4, "201", getProfessor("A@iiitd.ac.in"));
        s3_c1.setClassSchedule("Wednesday - 10am to 11am");
        Course s3_c2 = new Course("302", "B3", 4, "202", getProfessor("B@iiitd.ac.in"));
        s3_c2.setClassSchedule("Thursday - 11am to 12pm");
        Course s3_c3 = new Course("303", "C3", 4, "203", getProfessor("C@iiitd.ac.in"));
        s3_c3.setClassSchedule("Friday - 1pm to 2pm");
        Course s3_c4 = new Course("304", "D3", 4, "204", getProfessor("D@iiitd.ac.in"));
        s3_c4.setClassSchedule("Monday - 2pm to 3pm");
        Course s3_c5 = new Course("305", "E3", 4, "205", getProfessor("E@iiitd.ac.in"));
        s3_c5.setClassSchedule("Tuesday - 3pm to 4pm");
        Course s3_c6 = new Course("306", "F3", 2, "206", getProfessor("F@iiitd.ac.in"));
        s3_c6.setClassSchedule("Wednesday - 4pm to 5pm");
        Course s3_c7 = new Course("307", "G3", 2, "207", getProfessor("G@iiitd.ac.in"));
        s3_c7.setClassSchedule("Thursday - 5pm to 6pm");
        Course[] s3 = {s3_c1, s3_c2, s3_c3, s3_c4, s3_c5, s3_c6, s3_c7};

        Course s4_c1 = new Course("401", "A4", 4, "301", getProfessor("A@iiitd.ac.in"));
        s4_c1.setClassSchedule("Thursday - 11am to 12pm");
        Course s4_c2 = new Course("402", "B4", 4, "302", getProfessor("B@iiitd.ac.in"));
        s4_c2.setClassSchedule("Friday - 1pm to 2pm");
        Course s4_c3 = new Course("403", "C4", 4, "303", getProfessor("C@iiitd.ac.in"));
        s4_c3.setClassSchedule("Monday - 2pm to 3pm");
        Course s4_c4 = new Course("404", "D4", 4, "304", getProfessor("D@iiitd.ac.in"));
        s4_c4.setClassSchedule("Tuesday - 3pm to 4pm");
        Course s4_c5 = new Course("405", "E4", 4, "305", getProfessor("E@iiitd.ac.in"));
        s4_c5.setClassSchedule("Wednesday - 4pm to 5pm");
        Course s4_c6 = new Course("406", "F4", 2, "306", getProfessor("F@iiitd.ac.in"));
        s4_c6.setClassSchedule("Thursday - 5pm to 6pm");
        Course s4_c7 = new Course("407", "G4", 2, "307", getProfessor("G@iiitd.ac.in"));
        s4_c7.setClassSchedule("Friday - 8am to 9am");
        Course[] s4 = {s4_c1, s4_c2, s4_c3, s4_c4, s4_c5, s4_c6, s4_c7};

        Course s5_c1 = new Course("501", "A5", 4, "401", getProfessor("A@iiitd.ac.in"));
        s5_c1.setClassSchedule("Friday - 1pm to 2pm");
        Course s5_c2 = new Course("502", "B5", 4, "402", getProfessor("B@iiitd.ac.in"));
        s5_c2.setClassSchedule("Monday - 2pm to 3pm");
        Course s5_c3 = new Course("503", "C5", 4, "403", getProfessor("C@iiitd.ac.in"));
        s5_c3.setClassSchedule("Tuesday - 3pm to 4pm");
        Course s5_c4 = new Course("504", "D5", 4, "404", getProfessor("D@iiitd.ac.in"));
        s5_c4.setClassSchedule("Wednesday - 4pm to 5pm");
        Course s5_c5 = new Course("505", "E5", 4, "405", getProfessor("E@iiitd.ac.in"));
        s5_c5.setClassSchedule("Thursday - 5pm to 6pm");
        Course s5_c6 = new Course("506", "F5", 2, "406", getProfessor("F@iiitd.ac.in"));
        s5_c6.setClassSchedule("Friday - 8am to 9am");
        Course s5_c7 = new Course("507", "G5", 2, "407", getProfessor("G@iiitd.ac.in"));
        s5_c7.setClassSchedule("Monday - 9am to 10am");
        Course[] s5 = {s5_c1, s5_c2, s5_c3, s5_c4, s5_c5, s5_c6, s5_c7};

        Course s6_c1 = new Course("601", "A6", 4, "501", getProfessor("A@iiitd.ac.in"));
        s6_c1.setClassSchedule("Monday - 2pm to 3pm");
        Course s6_c2 = new Course("602", "B6", 4, "502", getProfessor("B@iiitd.ac.in"));
        s6_c2.setClassSchedule("Tuesday - 3pm to 4pm");
        Course s6_c3 = new Course("603", "C6", 4, "503", getProfessor("C@iiitd.ac.in"));
        s6_c3.setClassSchedule("Wednesday - 4pm to 5pm");
        Course s6_c4 = new Course("604", "D6", 4, "504", getProfessor("D@iiitd.ac.in"));
        s6_c4.setClassSchedule("Thursday - 5pm to 6pm");
        Course s6_c5 = new Course("605", "E6", 4, "505", getProfessor("E@iiitd.ac.in"));
        s6_c5.setClassSchedule("Friday - 8am to 9am");
        Course s6_c6 = new Course("606", "F6", 2, "506", getProfessor("F@iiitd.ac.in"));
        s6_c6.setClassSchedule("Monday - 9am to 10am");
        Course s6_c7 = new Course("607", "G6", 2, "507", getProfessor("G@iiitd.ac.in"));
        s6_c7.setClassSchedule("Tuesday - 10am to 11am");
        Course[] s6 = {s6_c1, s6_c2, s6_c3, s6_c4, s6_c5, s6_c6, s6_c7};

        Course s7_c1 = new Course("701", "A7", 4, "601", getProfessor("A@iiitd.ac.in"));
        s7_c1.setClassSchedule("Tuesday - 3pm to 4pm");
        Course s7_c2 = new Course("702", "B7", 4, "602", getProfessor("B@iiitd.ac.in"));
        s7_c2.setClassSchedule("Wednesday - 4pm to 5pm");
        Course s7_c3 = new Course("703", "C7", 4, "603", getProfessor("C@iiitd.ac.in"));
        s7_c3.setClassSchedule("Thursday - 5pm to 6pm");
        Course s7_c4 = new Course("704", "D7", 4, "604", getProfessor("D@iiitd.ac.in"));
        s7_c4.setClassSchedule("Friday - 8am to 9am");
        Course s7_c5 = new Course("705", "E7", 4, "605", getProfessor("E@iiitd.ac.in"));
        s7_c5.setClassSchedule("Monday - 9am to 10am");
        Course s7_c6 = new Course("706", "F7", 2, "606", getProfessor("F@iiitd.ac.in"));
        s7_c6.setClassSchedule("Tuesday - 10am to 11am");
        Course s7_c7 = new Course("707", "G7", 2, "607", getProfessor("G@iiitd.ac.in"));
        s7_c7.setClassSchedule("Wednesday - 11am to 12am");
        Course[] s7 = {s7_c1, s7_c2, s7_c3, s7_c4, s7_c5, s7_c6, s7_c7};

        Course s8_c1 = new Course("801", "A8", 4, "701", getProfessor("A@iiitd.ac.in"));
        s8_c1.setClassSchedule("Wednesday - 4pm to 5pm");
        Course s8_c2 = new Course("802", "B8", 4, "702", getProfessor("B@iiitd.ac.in"));
        s8_c2.setClassSchedule("Thurday - 5pm to 6pm");
        Course s8_c3 = new Course("803", "C8", 4, "703", getProfessor("C@iiitd.ac.in"));
        s8_c3.setClassSchedule("Friday - 8am to 9am");
        Course s8_c4 = new Course("804", "D8", 4, "704", getProfessor("D@iiitd.ac.in"));
        s8_c4.setClassSchedule("Monday - 9am to 10am");
        Course s8_c5 = new Course("805", "E8", 4, "705", getProfessor("E@iiitd.ac.in"));
        s8_c5.setClassSchedule("Tuesday - 10am to 11am");
        Course s8_c6 = new Course("806", "F8", 2, "706", getProfessor("F@iiitd.ac.in"));
        s8_c6.setClassSchedule("Wednesday - 11am to 12am");
        Course s8_c7 = new Course("807", "G8", 2, "707", getProfessor("G@iiitd.ac.in"));
        s8_c7.setClassSchedule("Thurday - 1pm to 2pm");
        Course[] s8 = {s8_c1, s8_c2, s8_c3, s8_c4, s8_c5, s8_c6, s8_c7};

        for (Course course : s1) c_catalog.add(course);
        for (Course course : s2) c_catalog.add(course);
        for (Course course : s3) c_catalog.add(course);
        for (Course course : s4) c_catalog.add(course);
        for (Course course : s5) c_catalog.add(course);
        for (Course course : s6) c_catalog.add(course);
        for (Course course : s7) c_catalog.add(course);
        for (Course course : s8) c_catalog.add(course);

        return c_catalog;
    }

    public static List<Professor> professorCatalog(){
        Professor A= new Professor("A@iiitd.ac.in","A");
        Professor B= new Professor("B@iiitd.ac.in","B");
        Professor C= new Professor("C@iiitd.ac.in","C");
        Professor D= new Professor("D@iiitd.ac.in","D");
        Professor E= new Professor("E@iiitd.ac.in","E");
        Professor F= new Professor("F@iiitd.ac.in","F");
        Professor G= new Professor("G@iiitd.ac.in","G");

        p_catalog.add(A);
        p_catalog.add(B);
        p_catalog.add(C);
        p_catalog.add(D);
        p_catalog.add(E);
        p_catalog.add(F);
        p_catalog.add(G);

        return p_catalog;

    }

    public static List<Course> getSemesterCourses(int sem) {
        List<Course> c_catalog = Catalog.courseCatalog();
        List<Course> semesterCourses = new ArrayList<>();

        int startIndex = (sem - 1) * 7;
        int endIndex = startIndex + 7;

        for (int i = startIndex; i < endIndex; i++) {
            semesterCourses.add(c_catalog.get(i));
        }

        return semesterCourses;
    }

    public static Professor getProfessor(String email){
        List<Professor> p_catalog = professorCatalog();
        for(Professor pr: p_catalog){
            if(pr.getEmail().equals(email)) return pr;
        }
        return null;
    }

    public static void setProfessor(Professor p,Course c){
        for(Course co :courseCatalog() ){
            if(co.equals(c)){
                co.setProfessor(p);
            }
        }
    }

    //OVERLOADING
    public static void setProfessor(String email,Course c){
        Professor p = getProfessor(email);
        for(Course co :courseCatalog() ){
            if(co.equals(c)){
                co.setProfessor(p);
            }
        }
    }

}
