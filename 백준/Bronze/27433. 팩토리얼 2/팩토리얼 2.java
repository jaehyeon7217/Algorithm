import java.util.*;
import java.io.*;

public class Main {

    public static long[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        arr[0]=1;

        System.out.println(func(n));

    }

    public static long func(int n){
        if(arr[n]==0){
            arr[n] = func(n-1) * n;
        }


        return arr[n];
    }


}
