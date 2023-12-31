package sis.util;

import junit.framework.*;

public class ParityCheckerTest extends TestCase {
   public void testSingleByte() {
      ParityChecker checker = new ParityChecker();
      byte source1  = 10;  // 1010
      byte source2  = 13;  // 1101
      byte source3  =  2;  // 0010

      byte[] data = new byte[] { source1, source2, source3 };

      byte checksum =  5;  // 0101

      assertEquals(checksum, checker.checksum(data));

      // corrupt an element
      data[1] = 14; // 1110

      assertFalse(checksum == checker.checksum(data));
   }

   public void testParity() {
      assertEquals(0, xorAll(0, 1, 0, 1));
      assertEquals(1, xorAll(0, 1, 1, 1));
   }

   private int xorAll(int first, int... rest) {
      int parity = first;
      for (int num: rest)
         parity ^= num;
      return parity;
   }
}