package sis.report;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import sis.studentinfo.*;

public class RosterReporterTest {

    @Test
	public void testRosterReport()  {
        Session session = CourseSession.create(new Course("ENGL", "101"),
                DateUtil.createDate(2003, 1, 6));

        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReporter(session).getReport();
        //System.out.println(rosterReport);
        assertEquals(RosterReporter.ROSTER_REPORT_HEADER +
            "A" + RosterReporter.NEWLINE +
            "B" + RosterReporter.NEWLINE +
            RosterReporter.ROSTER_REPORT_FOOTER +
            "2" + RosterReporter.NEWLINE, rosterReport);
    }

}
