package Lab6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Que1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c=0;
        try{
            int a=sc.nextInt();
            int b=sc.nextInt();

             c=a/b;

        }catch(InputMismatchException inputMismatchException){
            System.out.println("Invalid Input");
            inputMismatchException.printStackTrace();
        }catch(ArithmeticException arithmeticException){
            System.out.println("Dividing By Zero");
            arithmeticException.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Final Value:"+c);
        }
    }

}
