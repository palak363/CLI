# University Course Registration System - README

## Overview

This project implements a comprehensive university course registration system designed to manage student enrollments, academic progress, course schedules, and user roles such as students, professors, and administrators. It leverages advanced object-oriented programming principles and concepts such as **generic programming**, **exception handling**, **inheritance**, **polymorphism**, **encapsulation**, and **abstraction** to provide a robust, scalable, and user-friendly system.

## Key Features

### 1. **Student Functionalities**
- **View Available Courses**: View all available courses for the current semester, including course code, title, professor, credits, prerequisites, and timings.
- **Register for Courses**: Register for courses while adhering to prerequisites and credit limits (fixed to 20 credits).
- **View Schedule**: View weekly course schedules with class timings, locations, and professor names.
- **Track Academic Progress**: Track completed courses and compute SGPA and CGPA based on the grades.
- **Drop Courses**: Drop courses within a semester (with exception handling for deadlines).
- **Submit Complaints**: Submit complaints related to course issues (e.g., schedule clashes), which administrators can resolve.

### 2. **Professor Functionalities**
- **Manage Courses**: Professors can update course details such as syllabus, timings, credits, and office hours.
- **View Enrolled Students**: Professors can view a list of students enrolled in their courses.

### 3. **Administrator Functionalities**
- **Manage Course Catalog**: Administrators can view, add, and delete courses in the catalog.
- **Manage Student Records**: Administrators can view and modify student records, grades, and personal information.
- **Assign Professors to Courses**: Administrators can assign professors to courses based on expertise and availability.
- **Handle Complaints**: Administrators can view and resolve complaints submitted by students.

### 4. **Additional Features**
- **Generic Feedback System**: Students can give feedback on completed courses, which professors can view. Feedback can be numeric (ratings) or textual (comments). 
- **Enhanced User Role Management**: A Teaching Assistant (TA) role is introduced, extending the `Student` class to allow TAs to assist professors in grading without full privileges.
- **Exception Handling**: Robust error handling for scenarios such as invalid course registration, login errors, and dropping courses after deadlines.

---

### **Key OOP Concepts Used:**

#### **1. Encapsulation**:
   - Used to hide the internal data of classes like `Student`, `Professor`, and `Administrator`. Methods are provided to interact with the data, ensuring that sensitive information (e.g., grades or personal details) is secure.
   - Example: In the `Student` class, student grades are encapsulated and can only be updated by authorized roles (e.g., `Admin`).

#### **2. Inheritance**:
   - The **Teaching Assistant (TA)** class extends the `Student` class to add functionalities for grading assistance without duplicating the entire `Student` class.
   - Example: `TA` inherits all methods from `Student` but adds additional grading functionalities such as viewing and assisting with student grades.

#### **3. Polymorphism**:
   - Role-based polymorphism allows each user role (Student, Professor, Administrator, and TA) to interact with the system through the same interface while having distinct behaviors.
   - Example: The `login()` method can be overloaded for each role (Student, Professor, Admin), each invoking the correct actions based on the user type.

#### **4. Abstraction**:
   - Abstract classes and interfaces are used to define common behaviors for different entities. For instance, a `User` interface could define common methods like `login()` and `logout()`, with role-specific implementations.
   - Example: The `User` interface provides an abstraction layer for all user roles, allowing easy extension if additional roles are added in the future.

#### **5. Generic Programming**:
   - **Generic Feedback System**: This feature uses **generic classes** to store and manage feedback, allowing for both **numeric ratings** (1-5) and **textual comments**. This ensures flexibility in managing different types of feedback data.
   - Example: The `Feedback` class is designed as a generic class to accept any data type:
     ```java
     public class Feedback<T> {
         private T feedbackData;
         
         public Feedback(T feedbackData) {
             this.feedbackData = feedbackData;
         }
         
         public T getFeedback() {
             return feedbackData;
         }
     }
     ```
   - This allows users to store different types of feedback (numeric ratings or textual comments) without changing the structure of the class.

---

### **Exception Handling**:

To ensure a smooth user experience, custom exceptions are created to handle common errors in course registration and login processes:

#### **Custom Exceptions**:
- **CourseFullException**: Thrown when a student tries to register for a course that is already full.
- **InvalidLoginException**: Thrown when login credentials are incorrect.
- **DropDeadlinePassedException**: Thrown if a student attempts to drop a course after the deadline.

This ensures that the system is robust and provides clear feedback to the user when issues arise.

---

## Conclusion

This university course registration system implements essential features using core object-oriented principles such as **inheritance**, **polymorphism**, **abstraction**, and **encapsulation**. The addition of **generic programming** for feedback handling and **robust exception handling** for error management ensures that the system is both scalable and reliable. The system is designed for easy maintenance and extensibility, providing a solid foundation for any future enhancements such as adding new user roles or integrating a graphical user interface (GUI).
