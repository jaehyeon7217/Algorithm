import java.io.*;
import java.util.*;

public class Main {

    public static int n, k, result;
    public static int[][] memo;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        result = 0;
        memo = new int[n][k+1];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(i==0){
                for(int j=w;j<=k;j++){
                    memo[i][j] = m;
                }
            }else{
                for(int j=0;j<=k;j++){
                    if(j-w>=0)
                        memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-w] + m);
                    else memo[i][j] = memo[i-1][j];
                }
            }



        }
        for(int i=0;i<=k;i++){
            result = Math.max(memo[n-1][i], result);
        }

        System.out.println(result);

    }
}
