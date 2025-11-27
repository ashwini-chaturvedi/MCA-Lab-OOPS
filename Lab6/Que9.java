package Lab6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class DataProcessingException extends Exception {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Que9 {
    public static void processData() throws DataProcessingException {
        try {
            System.out.println("Trying to open the file...");
            FileInputStream fis = new FileInputStream("missingfile.txt"); // file doesn't exist

        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException. Now chaining...");
            throw new DataProcessingException("Error while processing data", e);  // chaining
        }
    }

    public static void main(String[] args) {

        try {
            processData();

        } catch (DataProcessingException e) {
            System.out.println("Caught DataProcessingException: " + e.getMessage());

            Throwable cause = e.getCause();
            System.out.println("Original cause: " + cause);

            System.out.println("\nFull stack trace with chained exception:");
            e.printStackTrace();
        }
    }
}
