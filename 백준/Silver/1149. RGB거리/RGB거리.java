import java.util.*;
import java.io.*;

public class Main {

	public static int n, result=Integer.MAX_VALUE ;
	public static int[][] list;
	public static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		list = new int[n][3];
		dp = new int[n][3];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = list[0][0];
		dp[0][1] = list[0][1];
		dp[0][2] = list[0][2];
		
		for(int i= 1; i<n;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + list[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + list[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + list[i][2];
		}
		
		for(int i=0;i<3;i++) 
			result = Math.min(result, dp[n-1][i]);
		
		
		
		System.out.println(result);
		
	}	
	
}
