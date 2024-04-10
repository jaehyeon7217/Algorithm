import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, num[i]);
            if (i == 0) {
                dp[0] = num[0];
            } else {
                dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            }

        }


        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }


        System.out.println(max);

    }


}