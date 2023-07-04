package sis;

import junit.framework.TestSuite;
import sis.report.AllTestsReport;
import sis.studentinfo.AllTestsStudentInfo;

public class AllTests {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(AllTestsReport.suite());
        suite.addTest(AllTestsStudentInfo.suite());
        return suite;
    }
}
