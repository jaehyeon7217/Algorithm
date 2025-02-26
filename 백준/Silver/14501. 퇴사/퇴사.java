import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        int max = 0;

        for(int i=0;i<n;i++){
            if(i + arr[i][0] -1 >= n){
                continue;
            }
            dp[i] = arr[i][1];
            for(int j=i-1;j>=0;j--){
                if( i > j+arr[j][0] -1 ){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

}