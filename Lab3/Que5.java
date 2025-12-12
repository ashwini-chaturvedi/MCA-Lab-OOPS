package Lab3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Que5 {
    public static void reverse(int[] arr,int low,int high){
        int i=low;
        int j=high;

        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the count of Elements: ");
        int n=Integer.parseInt(br.readLine());
        System.out.println("Size of the Array:"+n);
        int []arr=new int[n];
        System.out.println("Enter Elements in the Array:");
        String line;
        for(int i=-0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the times you want Array to rotate: ");
        int k=Integer.parseInt(br.readLine());
        System.out.println("Rotate Array "+k+" Times");
        System.out.println("Before Reversal Array:");
        for(int num:arr){
            System.out.print(num+",");
        }
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        System.out.println("\nReversed Array:");
        for(int num:arr){
            System.out.print(num+",");
        }

    }
}
