import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean x = true;
        while (x) {
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Find Student");
            System.out.println("4. Quit");
            int choice = sc.nextInt();
            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                showAllStudents();
            } else if (choice == 3) {
                findStudent();
            } else if (choice == 4) {
                x = false;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void addStudent() {
        System.out.println("Enter name: ");
        String a = sc.next();
        System.out.println("Enter age: ");
        int b = sc.nextInt();
        System.out.println("Enter ID: ");
        int c = sc.nextInt();
        studentList.add(new Student(a, b, c));
        System.out.println("Student added successfully!");
    }

    public static void showAllStudents() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("Name: " + studentList.get(i).name);
            System.out.println("Age: " + studentList.get(i).age);
            System.out.println("ID: " + studentList.get(i).id);
        }
    }

    public static void findStudent() {
        System.out.println("Enter ID to search:");
        int z = sc.nextInt();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == z) {
                System.out.println("Name: " + studentList.get(i).name);
                System.out.println("Age: " + studentList.get(i).age);
                System.out.println("ID: " + studentList.get(i).id);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void unusedMethod() {
        int x = 5;
        int y = x + 10;
    }
}

class Student {
    public String name;
    public int age;
    public int id;

    public Student(String n, int a, int i) {
        name = n;
        age = a;
        id = i;
    }
}
