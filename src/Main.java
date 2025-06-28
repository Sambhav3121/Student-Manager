public class Main {
    private static final StudentService service = new StudentService();
    private static final StudentView view = new StudentView();

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            view.showMenu();
            int choice = InputHelper.getIntInput("Enter your choice: ");
            isRunning = handleChoice(choice);
        }
    }
    private static boolean handleChoice(int choice) {
        switch (choice) {
            case 1 -> addStudent();
            case 2 -> showAllStudents();
            case 3 -> findStudent();
            case 4 -> {
                view.showMessage("Exiting...");
                return false;
            }
            default -> view.showMessage("Invalid choice. Please try again.");
        }
        return true;
    }
    
    private static void addStudent() {
        String name = InputHelper.getStringInput("Enter student name: ");
        int age = InputHelper.getIntInput("Enter student age: ");
        int id = InputHelper.getIntInput("Enter student ID: ");

        Student student = new Student(name, age, id);
        service.addStudent(student);
        view.showMessage("Student added successfully!");
    }

    private static void showAllStudents() {
        view.displayAllStudents(service.getAllStudents());
    }

    private static void findStudent() {
        int id = InputHelper.getIntInput("Enter student ID to search: ");
        Student student = service.findStudentById(id);
        view.displayStudent(student);
    }
}
