package Lab6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Que3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of the Array:");
        int n=input.nextInt();
        int []num=new int[n];
        try {
            for(int i=0;i<=n;i++){
                num[i]=input.nextInt();
            }
        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Array Index Out Of Bounds");
            arrayIndexOutOfBoundsException.printStackTrace();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid Input");
            inputMismatchException.printStackTrace();
        }catch (Exception e){
            System.out.println("Exception:");
            e.printStackTrace();
        }
    }
}
