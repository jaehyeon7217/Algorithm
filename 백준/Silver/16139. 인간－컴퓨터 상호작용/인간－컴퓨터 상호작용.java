import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char[] s = br.readLine().toCharArray();

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[s.length][26];

        for(int i=0;i<s.length;i++){
            if(i==0){
                dp[i][s[i]-'a']++;
            }else{
                for(int j=0;j<26;j++){
                    dp[i][j] = dp[i-1][j];
                }
                dp[i][s[i]-'a']++;
            }
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int alpha = st.nextToken().charAt(0) -'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == 0){
                sb.append(dp[end][alpha] + "\n");
            }else{
                sb.append(dp[end][alpha] - dp[start-1][alpha] + "\n");
            }

        }

        System.out.println(sb.toString());


    }
}
