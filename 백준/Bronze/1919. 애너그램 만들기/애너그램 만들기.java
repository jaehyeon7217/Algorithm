import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[] arr = new int[26];

        for(int i=0;i<a.length;i++){
            arr[a[i]-'a']++;
        }
        for(int i=0;i<b.length;i++){
            arr[b[i]-'a']--;
        }

        int sum = 0;
        for(int i=0;i<26;i++){
            sum += Math.abs(arr[i]);
        }

        System.out.println(sum);

    }

}
