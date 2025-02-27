import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            dp[i+1] = Math.max(dp[i + 1], dp[i]);

            if (i + t <= n) {
                dp[i + t] = Math.max(dp[i + t], dp[i] + p);
            }
        }

        System.out.println(dp[n]);


    }

}