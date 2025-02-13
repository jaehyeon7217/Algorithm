import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[10_001];

        dp[1] =1;

        int count = 1;
        int flag = 1;

        for(int i=2; i<=10000;i++){
            dp[i] = dp[i-1] +flag;
            if(count==5) dp[i]++;
            if(count==6) {
                count=0;
                flag++;
            }
            count++;
        }


        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]+ "\n");

        }
        System.out.println(sb);
    }



}
