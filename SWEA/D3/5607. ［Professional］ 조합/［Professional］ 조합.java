import java.io.*;
import java.util.*;

public class Solution {
	public static long n, r;
	public static long result;
	public static int mod= 1234567891;
	public static long[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long t = Integer.parseInt(br.readLine());
		factorial = new long[1000001];
		
		factorial[0] = factorial[1] = 1;
		
		for(int i=2;i<1000001;i++) {
			factorial[i] = (factorial[i-1]*i)%mod;
		}
		for (long T = 1; T <= t; T++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Long.parseLong(st.nextToken());
			r = Long.parseLong(st.nextToken());
			result = 1;

			
			
			// 페르마의 소정리
			result *= factorial[(int)n];
			
			result *= zegob((factorial[(int)n - (int)r] * factorial[(int)r])%mod, mod-2);
			result %= mod;
			


			sb.append("#" + T + " " + result + "\n");
		}

		System.out.println(sb.toString());

//			System.out.println(result);
	}

	public static long zegob(long num, int s) {
		if (s == 0)
			return 1;

		if (s % 2 == 0) {
			long temp = zegob(num, s / 2);
			return (temp % mod * temp % mod) % mod;
		}

		long temp = zegob(num, s - 1) % mod;
		return (num * temp) % mod;

	}

}
