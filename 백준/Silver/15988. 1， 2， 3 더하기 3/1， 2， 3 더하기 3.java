import java.io.*;
import java.util.*;

public class Main {

    public static final int mod = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<1000001;i++){
            dp[i] = ((dp[i-1]+dp[i-2])%mod + dp[i-3]%mod)%mod;
        }

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + " \n");
        }
        System.out.println(sb);
    }


}
