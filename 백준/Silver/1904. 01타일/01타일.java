import java.io.*;
import java.util.*;

public class Main {
    public static final int DIV = 15746;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        if(n<=2){
            System.out.println(n);
            System.exit(0);
        }
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2;i<n;i++){
            dp[i] = (dp[i-2]%DIV + dp[i-1]%DIV)%DIV;
        }
        System.out.println(dp[n-1]);

    }

}
