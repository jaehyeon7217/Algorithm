import java.io.*;
import java.util.*;

public class Main {

    public static int[][][] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        
        int a = A/C;
        if(a * C < A) a++;
        int b = B/D;
        if(b *D < B) b++;


        System.out.println(L - (Math.max(a,b)));
        
        


    }



}