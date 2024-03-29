import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int size = Integer.parseInt(br.readLine());

        for(int i=0;i<size;i++){
            boolean[] alphabet = new boolean[26];
            boolean flag = true;

            char[] c = br.readLine().toCharArray();

            for(int j=0;j<c.length;j++){
                if(alphabet[c[j]-'a'] && (c[j-1] != c[j])) {
                    flag = false;
                    break;
                }
                alphabet[c[j] -'a'] = true;
            }
            if(flag) count++;

        }
        System.out.println(count);

    }



}