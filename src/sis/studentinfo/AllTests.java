package sis.studentinfo;

import junit.framework.TestSuite;
import sis.report.RosterReporterTest;

public class AllTests {
    public static TestSuite suite() {
        junit.framework.TestSuite suite = new junit.framework.TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(DateUtilTest.class);
        return suite;
    }
}
