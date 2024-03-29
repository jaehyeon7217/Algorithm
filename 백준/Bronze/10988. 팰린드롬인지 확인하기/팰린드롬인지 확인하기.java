import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();

        int size = c.length;

        for(int i=0;i<size/2;i++){
            if(c[i] != c[size-1-i]) {
                System.out.println(0);
                System.exit(0);
            }
        }

        System.out.println(1);

    }



}