import java.io.*;
import java.util.*;

public class Main {

    public static int n, max = Integer.MIN_VALUE;
    public static int[] arr, pick;
    public static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        pick = new int[n];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0);

        System.out.println(max);

    }

    public static void func(int step){
        if(step == n){
            int temp = 0;
            for(int i=0;i<n-1;i++){
                temp += Math.abs(pick[i] - pick[i+1]);
            }

            max = Math.max(max, temp);
            return;
        }

        for(int i=0;i<n;i++){
            if(check[i]) continue;
            check[i] = true;
            pick[step] = arr[i];
            func(step+1);
            check[i] = false;
        }

    }


}