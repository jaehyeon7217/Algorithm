import java.io.*;
import java.util.*;

public class Main {

    public static int n, k;
    public static int[] arr, dp;
    public static final int max = 1234567890;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[k + 1];

        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        System.out.println(dp[k]==max ? "-1" : dp[k]);

    }


}