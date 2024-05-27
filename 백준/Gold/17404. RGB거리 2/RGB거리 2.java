import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        dp = new int[n+1][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());

        }
        int result = 1234567890;
        for(int j=0;j<3;j++) {

            for(int i=0;i<3;i++){
                if(i==j) dp[0][i] = arr[0][i];
                else dp[0][i] = 1234567890;
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(arr[i][0] + dp[i - 1][1], arr[i][0] + dp[i - 1][2]);
                dp[i][1] = Math.min(arr[i][1] + dp[i - 1][0], arr[i][1] + dp[i - 1][2]);
                dp[i][2] = Math.min(arr[i][2] + dp[i - 1][0], arr[i][2] + dp[i - 1][1]);
            }

            for(int i=0;i<3;i++){
                if(i==j) continue;
                result= Math.min(result, dp[n-1][i]);
            }

        }
        System.out.println(result);




    }


}
