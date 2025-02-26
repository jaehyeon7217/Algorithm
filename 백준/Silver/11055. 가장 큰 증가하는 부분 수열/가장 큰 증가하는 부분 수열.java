import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i=0;i<n;i++){
            dp[i] = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);



    }

}