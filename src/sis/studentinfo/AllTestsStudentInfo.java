package sis.studentinfo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CourseSessionTest.class, DateUtilTest.class, StudentTest.class,
	BasicGradingStrategyTest.class, HonorsGradingStrategyTest.class, 
	PerformanceTest.class, ScorerTest.class, StudentDirectoryTest.class,
	CourseTest.class, AccountTest.class})
public class AllTestsStudentInfo {

}
