package Lab6.Revision;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Que4 {
    public static void main(String[] args) throws IOException {
        String fileName="input.txt";
        try(FileInputStream fis=new FileInputStream(fileName)){
            fis.read();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
