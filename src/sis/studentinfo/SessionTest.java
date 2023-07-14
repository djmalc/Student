package sis.studentinfo;
import java.net.*;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import static sis.studentinfo.DateUtil.createDate;
import java.util.*;

import org.junit.jupiter.api.Test;

abstract public class SessionTest {
	private static final int CREDITS = 3;
    private Session session;
    private Date startDate;

    @BeforeEach
    public void setUp() {
    	startDate = createDate(2003, 1, 6);
    	session = createSession(new Course("ENGL", "101"), startDate);
    	session.setNumberOfCredits(CREDITS);
    }
    
    abstract protected Session createSession(Course course, Date startDate);
    
    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    @Test
    public void testEnrollStudents() {
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }
	
    @Test
    public void testComparable() {
    	final Date date = new Date();
    	Session sessionA = CourseSession.create(new Course("CMSC",  "101"), date);
    	Session sessionB = CourseSession.create(new Course("ENGL",  "101"), date);
    	assertTrue(sessionA.compareTo(sessionB) < 0);
    	assertTrue(sessionB.compareTo(sessionA) > 0);
    	
    	Session sessionC = CourseSession.create(new Course("CMSC",  "101"), date);
    	assertEquals(0, sessionA.compareTo(sessionC));
    	
    	Session sessionD = CourseSession.create(new Course("CMSC",  "210"), date);
    	assertTrue(sessionC.compareTo(sessionD) < 0);
    	assertTrue(sessionD.compareTo(sessionC) > 0);
    	
    	
    }
    
    @Test
    public void testIterate() {
    	enrollStudents(session);
    	
    	List<Student> results = new ArrayList<Student>();
    	for (Student student: session)
    		results.add(student);
    	
    	assertEquals(session.getAllStudents(), results);
    }
    
    private void enrollStudents(Session session) {
    	session.enroll(new Student("1"));
    	session.enroll(new Student("2"));
    	session.enroll(new Student("3"));
    }

    @Test
    public void testSessionUrl() throws SessionException {
    	final String url = "http://course.lamgrsoft.com/cmsc300";
    	session.setUrl(url);
    	assertEquals(url, session.getUrl().toString());
    }

    @Test
    public void testInvalidSessionUrl()  {
    	final String url = "httsp://course.lamgrsoft.com/cmsc300";
    	try {
    		session.setUrl(url);
    		fail("expected exception due to invalid protocol in URL");
    	} catch (SessionException expectedException) {
    		Throwable cause = expectedException.getCause();
    		assertEquals(MalformedURLException.class, cause.getClass());
    	}
    }
    
}
