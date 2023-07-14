package sis;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ sis.report.AllTestsReport.class, sis.studentinfo.AllTestsStudentInfo.class, 
	sis.summer.AllTestsSummer.class})
public class AllTests {

}

//import junit.framework.TestSuite;
//import sis.report.AllTestsReport;
//import sis.studentinfo.AllTestsStudentInfo;
//
//public class AllTests {
//    public static TestSuite suite() {
//        TestSuite suite = new TestSuite();
//        suite.addTest(AllTestsReport.suite());
//        suite.addTest(AllTestsStudentInfo.suite());
//        return suite;
//    }
//}
