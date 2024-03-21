import java.io.*;
import java.util.*;

public class Main {

    public static int count1=0, count2=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.println(count1 + " " + count2);


    }

    public static int fib(int n){
        if(n==1 || n==2){
            count1++;
            return 1;
        }
        else{
            return (fib(n-1) + fib(n-2));
        }
    }

    public static int fibonacci(int n){
         int[] f = new int[n+1];

         f[1] = 1;
         f[2] = 1;

         for(int i=3;i<=n;i++){
             count2++;
             f[i] = f[n-1] + f[n-2];
         }
         return f[n];

    }

}