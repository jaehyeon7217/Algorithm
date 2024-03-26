import java.io.*;
import java.util.*;

public class Main {

    public static int n, k;
    public static int[] arr, money;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        money = new int[k+1];
        money[0] = 1;

        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(br.readLine());

            for(int j=arr[i]; j<=k;j++){
                money[j] += money[j-arr[i]];
            }


        }
        System.out.println(money[k]);


    }



}