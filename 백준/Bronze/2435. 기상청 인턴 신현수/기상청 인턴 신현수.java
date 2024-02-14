import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] temp = new int[N];
        for(int i=0;i<N;i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        dp[0]=0;
        for(int i=1;i<=N;i++){
            dp[i] = dp[i-1] + temp[i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int i=N;i-K>=0;i--){
            max = Math.max(max, dp[i] - dp[i-K]);
        }

        System.out.println(max);

    }
}