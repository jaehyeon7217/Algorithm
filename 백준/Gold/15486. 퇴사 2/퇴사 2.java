import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(System.in);

        st.nextToken();
        int n = (int)st.nval;

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st.nextToken();
            int t = (int)st.nval;
            st.nextToken();
            int p = (int)st.nval;

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            if (i + t <= n) {
                dp[i + t] = Math.max(dp[i + t], dp[i] + p);
            }
        }

        System.out.println(dp[n]);


    }

}