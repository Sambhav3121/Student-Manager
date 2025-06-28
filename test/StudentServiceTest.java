import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testAddStudent() {
        StudentService service = new StudentService();
        Student s = new Student("Alice", 20, 101);
        service.addStudent(s);
        assertEquals(1, service.getAllStudents().size());
    }

    @Test
    public void testFindStudentById_existing() {
        StudentService service = new StudentService();
        Student s = new Student("Bob", 22, 102);
        service.addStudent(s);

        Student result = service.findStudentById(102);
        assertNotNull(result);
        assertEquals("Bob", result.getName());
    }

    @Test
    public void testFindStudentById_nonexistent() {
        StudentService service = new StudentService();
        Student result = service.findStudentById(999);
        assertNull(result);
    }
}
