package sis.studentinfo;
import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course
 * @author David J Malcolm
 */
public class CourseSession extends Session {
	private static int count;
    
    public static Session create(
    	Course course,
    	Date startDate) {
    	incrementCount();
    	return new CourseSession(course, startDate);
    }
     
    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    static void resetCount() {
    	count = 0;
    }
    
    private static void incrementCount() {
    	++count;
    }
    
    static int getCount() {
    	return count;
    }
    
    protected int getSessionLength() {
    	return 16;
    }
}
