package sis.report;

import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

import org.junit.jupiter.api.Test;

import sis.studentinfo.CourseSession;

import static org.junit.jupiter.api.Assertions.*;

public class CourseReportTest {
	
	@Test
	public void testReport() {
		final Date date = new Date();
		CourseReport report = new CourseReport();
		report.add(create("ENGL", "101", date));
		report.add(create("CZEC", "200", date));
		report.add(create("ITAL", "410", date));
		report.add(create("CZEC", "220", date));
		report.add(create("ITAL", "330", date));
		
		assertEquals(
			"CZEC 200" + NEWLINE +
			"CZEC 220" + NEWLINE +
			"ENGL 101" + NEWLINE +
			"ITAL 330" + NEWLINE +
			"ITAL 410" + NEWLINE,
			report.text());
	}
	private Session create(String name, String number, Date date) {
		return CourseSession.create(new Course(name, number),  date);
	}
}
