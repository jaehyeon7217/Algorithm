import java.io.*;
import java.util.*;

public class Main {

    // n 1024, m 100,000
    public static int n, m;

    public static int[][] dp,map;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(j==0) dp[i][j] = map[i][j];
                else dp[i][j] = dp[i][j-1] + map[i][j];
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            if (op == 0) {
                int value = Integer.parseInt(st.nextToken());

                int diff = value - map[x1][y1];
                for(int j=y1; j<n; j++){
                    dp[x1][j] += diff;
                }
                map[x1][y1] = value;
            }
            else{
                int x2 = Integer.parseInt(st.nextToken())-1;
                int y2 = Integer.parseInt(st.nextToken())-1;

                int sum = 0;
                for(int j=x2;j>=x1;j--){
                    if(y1 == 0) sum+=dp[j][y2];
                    else sum+= dp[j][y2] - dp[j][y1-1];
                }
                sb.append(sum+"\n");
            }
        }

        System.out.println(sb.toString());

    }

}
