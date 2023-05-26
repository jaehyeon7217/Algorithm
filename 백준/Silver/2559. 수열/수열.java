import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            if(i==0){
                dp[i] = Integer.parseInt(st.nextToken());
            }else{
                dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
            }
        }

        int max = dp[m-1];
        for(int i=m;i<n;i++){
            max = Math.max(max, dp[i]-dp[i-m]);
        }

        System.out.println(max);

    }
}
