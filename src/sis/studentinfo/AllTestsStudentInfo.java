package sis.studentinfo;

import junit.framework.TestSuite;

public class AllTestsStudentInfo {
    public static TestSuite suite() {
        junit.framework.TestSuite suite = new junit.framework.TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(DateUtilTest.class);
        return suite;
    }
}
