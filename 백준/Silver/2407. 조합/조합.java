import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception { // 메인 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입렭받기
		StringTokenizer st ; // 공백을 기준으로 문자열 스플릿
		
			st = new StringTokenizer(br.readLine()); // 공백 기준 스플릿
			int n = Integer.parseInt(st.nextToken()); // 마을의 갯수
			int p = Integer.parseInt(st.nextToken()); // 경찰서의 갯수
			
			BigInteger[] dp = new BigInteger[p]; // nCr을 담을 DP
			
			dp[0]= new BigInteger(""+n); // 첫 번째 nC1 = n
			
			// dp 점화식
			// nC2 = n * (n-1) / 2 * 1 = nC1*(n-1)/2
			// nC3 = n * (n-1) * (n-2) / 3 * 2 * 1 = nC2* (n-2)/3
			// nCr = n * (n-1) * (n-2) * ... * (n-r-1) / r * (r-1) * ... * 3 * 2 * 1
			//     = nC(r-1) * (n-r-1) / r
			
			for(int i=1;i<p;i++) {
//				dp[i] = (dp[i-1]*(n-i))/(i+1);
				dp[i] = dp[i-1].multiply(new BigInteger(""+(n-i)));
				dp[i] = dp[i].divide(new BigInteger(""+(i+1)));
			}
			
		
		System.out.println(dp[p-1]); // 출력
		
	}
	
}
