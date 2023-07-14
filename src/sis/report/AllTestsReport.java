package sis.report;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ RosterReporterTest.class, CourseReportTest.class, ReportCardTest.class })
public class AllTestsReport {

}
