package sis.studentinfo;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
	@Test
	public void testTransactions() {
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.00"));
		assertEquals(new BigDecimal("11.10"), account.getBalance());
		account.credit(new BigDecimal("2.99"));
		assertEquals(new BigDecimal("4.70"), account.transactionAverage());
	}
}
