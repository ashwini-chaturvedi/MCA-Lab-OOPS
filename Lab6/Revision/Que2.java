package Lab6.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InvalidAgeException extends Throwable{
    InvalidAgeException(String message){
        super(message);
    }
}
public class Que2 {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int age;

        try{
            age=Integer.parseInt(br.readLine());
            if(age<0 || age>150) throw new InvalidAgeException("Invalid AGE!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        }
    }
}
