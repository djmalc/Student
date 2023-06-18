package studentinfo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest extends TestCase {
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());

        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());

        assertEquals(firstStudentName, firstStudent.getName());
    }

}
