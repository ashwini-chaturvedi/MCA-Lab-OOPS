package Lab6.Revision;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Que1 {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a;
        int b;

        try{
            System.out.println("Enter the Numbers:");
            a=Integer.parseInt(br.readLine());
            b=Integer.parseInt(br.readLine());

            int val=a/b;
            System.out.println(val);
        }catch(InputMismatchException | IOException | ArithmeticException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
