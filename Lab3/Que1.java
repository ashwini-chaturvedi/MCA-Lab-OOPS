package Lab3;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Que1 {
    public static void reverseList(List<Integer>list){
        int i=0;
        int j=list.size()-1;

        while(i<j){
            int temp=list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list=new ArrayList<>();
        String line;

        while((line=br.readLine())!=null && !line.isEmpty()){
            list.add(Integer.parseInt(line));
        }
        list.forEach(ele-> System.out.print(ele+"-"));
        System.out.println("\nReversed:");
        reverseList(list);
        list.forEach(ele-> System.out.print(ele+"-"));

    }
}
