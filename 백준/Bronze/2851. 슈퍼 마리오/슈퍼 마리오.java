import java.io.*;
import java.util.*;

public class Main {

    public static int n = 10;

    public static int[] map = new int[10];
    public static int[] dp = new int[10];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        boolean flag = true;

        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(br.readLine());
            if(i==0){
                dp[i] = map[i];
            }else{
                dp[i] = dp[i-1] + map[i];
            }

            if(dp[i] > 100 && flag){
                if(Math.abs(100-dp[i-1]) == Math.abs(100-dp[i])){
                    result = dp[i];
                }else {
                    result = Math.abs(100 - dp[i - 1]) > Math.abs(100 - dp[i]) ? dp[i] : dp[i - 1];
                }
                flag = false;
            }
        }

        System.out.println(result == 0 ? dp[n-1] : result);
    }

}
