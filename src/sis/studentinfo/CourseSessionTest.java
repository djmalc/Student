package sis.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest extends SessionTest {

    protected Session createSession(Course course, Date date) {        
    	return CourseSession.create(course,  date);
    }

    private Course createCourse() {
    	return new Course("ENGL", "101");
    }
   
    @Test
    public void testCount() {
    	//assertEquals(1, CourseSession.count());
    	CourseSession.resetCount();
    	createSession(createCourse(), new Date());
    	assertEquals(1, CourseSession.getCount());
    	createSession(createCourse(), new Date());
    	assertEquals(2, CourseSession.getCount());
    }

    @Test
    public void testCourseDates() {
        Date startDate = DateUtil.createDate(2003,  1,  6);
        Session session = createSession(createCourse(), startDate);
    	Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

}
