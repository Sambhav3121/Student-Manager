import java.util.List;

public class StudentView {
    public void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Show All Students");
        System.out.println("3. Find Student by ID");
        System.out.println("4. Exit");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            System.out.println(student.toString());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                System.out.println(s.toString());
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
