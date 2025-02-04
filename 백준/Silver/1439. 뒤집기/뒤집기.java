import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();

        int count = 0;

        for(int i=1;i<a.length;i++){
            if(a[i] != a[i-1]) count++;
        }

        System.out.println( (count+1)/2);




    }

}
