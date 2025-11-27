package Lab6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Que6 {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            System.out.println("Copying file...");

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }

       System.out.println("Try-with-resources block ended. Streams closed automatically.");

    }
}
