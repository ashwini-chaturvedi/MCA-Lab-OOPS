package Lab6.Revision;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Que6 {
    public static void main(String[] args) {
        String fileA="input.txt";
        String fileB="output.txt";
        try{
            FileInputStream fis=new FileInputStream(fileA);
            FileOutputStream fos=new FileOutputStream(fileB);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
