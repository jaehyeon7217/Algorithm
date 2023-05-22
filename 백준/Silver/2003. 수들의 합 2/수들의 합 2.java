import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] map = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());


        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(st.nextToken());
            if(i==0){
                dp[i] = map[i];
            }else{
                dp[i] = dp[i-1] + map[i];
            }
        }

        for(int i=n-1; i>=0; i--){
            if(dp[i] == m ){
                count++;
            }
            for(int j=i-1; j>=0; j--){
                int sum = dp[i]-dp[j];
                if(sum == m) {
                    count++;
                }
            }
        }


        System.out.println(count);

    }

}
