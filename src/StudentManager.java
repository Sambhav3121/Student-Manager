import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    static class Student {
        String name;
        int age;
        int id;

        Student(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int choice = scanner.nextInt();
            isRunning = handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Show All Students");
        System.out.println("3. Find Student by ID");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static boolean handleChoice(int choice) {
        switch (choice) {
            case 1 -> addStudent();
            case 2 -> showAllStudents();
            case 3 -> findStudent();
            case 4 -> {
                System.out.println("Exiting...");
                return false;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student newStudent = new Student(name, age, id);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        for (Student s : students) {
            printStudent(s);
        }
    }

    private static void findStudent() {
        System.out.print("Enter student ID to search: ");
        int searchId = scanner.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == searchId) {
                printStudent(s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void printStudent(Student s) {
        System.out.println("Name: " + s.name + ", Age: " + s.age + ", ID: " + s.id);
    }
}
