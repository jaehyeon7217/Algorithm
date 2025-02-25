import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] s = br.readLine().toCharArray();

        int[] arr= new int[s.length];

        for(int i=0;i<s.length;i++){
            arr[i] = s[i]-'0';
        }

        Arrays.sort(arr);

        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
        }

        System.out.println(sb);

    }



}
