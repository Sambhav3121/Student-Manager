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

    private static final int ADD_STUDENT = 1;
    private static final int SHOW_ALL = 2;
    private static final int FIND_STUDENT = 3;
    private static final int EXIT = 4;

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int choice = getIntInput("Enter your choice: ");
            isRunning = handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println(ADD_STUDENT + ". Add Student");
        System.out.println(SHOW_ALL + ". Show All Students");
        System.out.println(FIND_STUDENT + ". Find Student by ID");
        System.out.println(EXIT + ". Exit");
    }

    private static boolean handleChoice(int choice) {
        switch (choice) {
            case ADD_STUDENT -> addStudent();
            case SHOW_ALL -> showAllStudents();
            case FIND_STUDENT -> findStudent();
            case EXIT -> {
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
        int age = getIntInput("Enter student age: ");
        int id = getIntInput("Enter student ID: ");

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
        int searchId = getIntInput("Enter student ID to search: ");
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

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }
}
