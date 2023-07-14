package sis.studentinfo;
import java.util.*;
import java.net.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course
 * @author David J Malcolm
 */
abstract public class Session implements Comparable<Session>, Iterable<Student> {

	private URL url;
    private List<Student> students = new ArrayList<Student>();
    private Course course;
    private Date startDate;
    private int numberOfCredits;

    protected Session(Course course, Date startDate) {
        this.course = course;
        this.startDate = startDate;
    }

    public int compareTo(Session that) {
    	int compare = this.getDepartment().compareTo(that.getDepartment());
    	if (compare == 0)
    		compare = this.getNumber().compareTo(that.getNumber());
    	return compare;
    }
    
    public Iterator<Student> iterator() {
    	return students.iterator();
    }
    
    public void setUrl(String urlString) throws SessionException {
    	try {
    		this.url = new URL(urlString);
    	}
    	catch (MalformedURLException e) {
    		log(e);
    		throw new SessionException(e);
    	}
    }
    
    private void log(Exception e) {
    	// logging code TBD
    	//e.printStackTrace();
    }
    
    public URL getUrl() {
    	return url;
    }
    
    void setNumberOfCredits(int numberOfCredits) {
    	this.numberOfCredits = numberOfCredits;
    }
    
    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
    }

    int getNumberOfStudents() {
        return students.size();
    }


    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
    	students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }

    protected Date getStartDate() {
        return startDate;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    abstract protected int getSessionLength();
    /**
     *
     * @return Date the last date of the course session
     */
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
		int daysInWeek = 7;
		int daysFromFridayToMonday = 3;
        int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
        calendar.add(calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
    
}




