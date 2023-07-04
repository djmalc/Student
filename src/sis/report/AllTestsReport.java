package sis.report;

import junit.framework.TestSuite;
public class AllTestsReport {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(RosterReporterTest.class);
        return suite;
    }
}
