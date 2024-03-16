import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n==0 || n==1){
            System.out.println(n);
        }else {
            long[] array = new long[n+1];
            array[0]=0;
            array[1]=1;

            for(int i=2;i<=n;i++){
                array[i] = array[i-1] + array[i-2];
            }

            System.out.println(array[n]);


        }



    }
}