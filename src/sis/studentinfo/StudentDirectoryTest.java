package sis.studentinfo;

import java.io.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDirectoryTest {
   private StudentDirectory dir;

   @BeforeEach
   protected void setUp() {
      dir = new StudentDirectory();
   }

   @Test
   public void testStoreAndRetrieve() throws IOException {
      final int numberOfStudents = 10;

      for (int i = 0; i < numberOfStudents; i++)
         addStudent(dir, i);

      for (int i = 0; i < numberOfStudents; i++)
         verifyStudentLookup(dir, i);
  }

  void addStudent(StudentDirectory directory, int i)
         throws IOException {
      String id = "" + i;
      Student student = new Student(id);
      student.setId(id);
      student.addCredits(i);
      directory.add(student);
   }

   void verifyStudentLookup(StudentDirectory directory, int i)
         throws IOException {
      String id = "" + i;
      Student student = dir.findById(id);
      assertEquals(id, student.getLastName());
      assertEquals(id, student.getId());
      assertEquals(i, student.getCredits());
   }
}