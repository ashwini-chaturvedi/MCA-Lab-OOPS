package Lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Que10 {
    private static boolean isValidAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int i=0;
        int[] counter=new int[26];

        while(i<s1.length()){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);

            counter[ch1-'a']++;
            counter[ch2-'a']--;
            i++;
        }

        for(int num:counter){
            if(num!=0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s1=br.readLine();
        String s2=br.readLine();

        boolean ans=isValidAnagram(s1,s2);
        System.out.println("Are these 2 strings Anagrams:"+ans);


    }


}
