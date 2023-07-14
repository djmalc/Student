package sis.summer;

import java.util.*;
import sis.studentinfo.*;

public class SummerCourseSession extends Session {
	private static int count;
	public static Session create(Course course, Date startDate) {
		return new SummerCourseSession(course, startDate);
	}
	
	private SummerCourseSession(Course course, Date startDate) {
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
	
	@Override
	protected int getSessionLength() {
		return 8;
	}
}
