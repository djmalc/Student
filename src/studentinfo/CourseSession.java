package studentinfo;
import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course
 * @author david j malcolm
 */
public class CourseSession {

    private String department;
    private String number;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Date startDate;

    CourseSession() {
    }

    /**
     * Constructs a CourseSession starting on a specific date
     * @param startDate the date on which the CourseSession begins
     */
    CourseSession(Date startDate) {
        this.startDate = startDate;
    }
    CourseSession(String department, String number) {
        this.department = department;
        this.number = number;
    }

    CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    ArrayList<Student> getAllStudents() {
        return students;
    }
    /**
     *
     * @return Date the last date of the course session
     */
    Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 -3;
        calendar.add(calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
    String getDepartment() {
        return department;
    }

    String getNumber() {
        return number;
    }

    Date getStartDate() {
        return startDate;
    }

    int getNumberOfStudents() {
        return students.size();
    }


    void enroll(Student student) {
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }
}
