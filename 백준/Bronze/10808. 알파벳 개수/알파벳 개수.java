import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] s = br.readLine().toCharArray();

        int[] alphabet = new int[26];

        for(int i=0;i<s.length;i++){
            alphabet[s[i]-'a']++;
        }

        for(int i=0;i<26;i++){
            sb.append(alphabet[i] + " ");
        }
        System.out.println(sb.toString());


    }




}