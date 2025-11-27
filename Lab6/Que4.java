package Lab6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Que4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=null;
        Scanner input=new Scanner(System.in);
        String fileName=input.nextLine().trim();
        try{
            System.out.println("Opening the File:"+fileName);
            fis=new FileInputStream(fileName);

            System.out.println("File opened");
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }finally {
            System.out.println("In Finally Block");
            if(fis!=null){
               fis.close();
            }
        }
    }
}
