package util;

import java.util.logging.*;

class MockMemoryHandler extends ConsoleHandler {
   private String message;

   public void publish(LogRecord record) {
      super.publish(record);
      message = record.getMessage();
   }

   String getMessage() {
      return message;
   }
}