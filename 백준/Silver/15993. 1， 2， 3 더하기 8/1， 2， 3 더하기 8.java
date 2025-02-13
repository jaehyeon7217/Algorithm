import java.io.*;
import java.util.*;

public class Main {

    public static int[][] dp = new int[100_001][2];
    public static final int Max = 1_000_000_009;
    public static int now;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<100001;i++){
            Arrays.fill(dp[i],-1);
        }

        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;

        now=3;

        for(int t = 0; t<T;t++){
            int n = Integer.parseInt(br.readLine());

            if(n<=now){
                sb.append(dp[n][0] + " " + dp[n][1] + "\n");
                continue;
            }

            now++;
            for(int i=now; i<=n;i++){
                dp[i][0] = ((dp[i-1][1]%Max + dp[i-2][1]%Max)%Max + dp[i-3][1]%Max)%Max;
                dp[i][1] = ((dp[i-1][0]%Max + dp[i-2][0]%Max)%Max + dp[i-3][0]%Max)%Max;
            }
            now=n;

            sb.append(dp[n][0] + " " + dp[n][1] + "\n");

        }

        System.out.println(sb.toString());


    }

}
