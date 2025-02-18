import java.util.*;
import java.io.*;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[21];

        for (int i = 1; i <= 20; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a==b) continue;
            
            func(a,b);

        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<=20;i++){
            sb.append(arr[i] + " ");
        }

        System.out.println(sb);

    }

    public static void func(int a, int b) {

        /*
        5 10
        5 6 7 8 9 10
        10 9 8 7 6 5
         */

        for (int i = 0; i < (b - a) / 2 + 1; i++) {
            int temp = arr[a+i];
            arr[a+i] = arr[b-i];
            arr[b-i] = temp;
        }

    }

}
