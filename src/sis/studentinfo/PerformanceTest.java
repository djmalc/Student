package sis.studentinfo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {
	private static final double tolerance = 0.005;
	
	@Test
	public void testAverage() {
		Performance performance = new Performance();
		performance.setNumberOfTests(4);
		performance.set(0, 98);
		performance.set(1, 92);
		performance.set(2, 81);
		performance.set(3, 72);

		assertEquals(92, performance.get(1));
		
		assertEquals(85.75, performance.average(), tolerance);
	}
}
