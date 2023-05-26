import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static long count = 0;

    public static long[] dp;
    public static long[] dp2;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new long[n];
        dp2 = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = Long.parseLong(st.nextToken());
            } else {
                dp[i] = dp[i - 1] + Long.parseLong(st.nextToken());
            }
            dp2[(int)(dp[i]%m)]++;
            if(dp[i]%m == 0)count++;
        }
        for(int i=0;i<m;i++){
            if(dp2[i]>=2){
                count+= nc2(dp2[i]);
            }
        }

        System.out.println(count);
    }

    public static long nc2(long n) {
        return (n * (n - 1)) / 2;
    }

}
