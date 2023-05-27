import java.io.*;
import java.util.*;


public class Main {
	public static long n, r;
	public static long result;
	public static int mod;
	public static long[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
			st = new StringTokenizer(br.readLine(), " ");
			n = Long.parseLong(st.nextToken());
			r = Long.parseLong(st.nextToken());
			mod = Integer.parseInt(st.nextToken());
			result = 1;
			
			factorial = new long[mod+1];
			
			if( r== 0 || n==r ) result = 1;
			else if( r==1 || r== n-1) result = n%mod;
			else {
				factorial[0] = 1;
				factorial[1] = 1;
				
				for(int i=2;i<=mod;i++) {
					factorial[i] = (factorial[i-1] * i)%mod;
				}
				
				if(n<mod) {
					result *= factorial[(int)n];
					result %= mod;
					
					result *= zegob(factorial[(int)n - (int)r], mod-2);
					result %= mod;
					
					result *= zegob(factorial[(int)r], mod-2);
					result %= mod;
				}
				
				else {
					while(n>0 || r>0) {
						long tempN = n%mod;
						long tempR = r%mod;
						if(tempN<tempR) {
							result = 0;
							break;
						}
						
						result *= factorial[(int)tempN];
						result %= mod;
						
						result *= zegob(factorial[(int)tempN - (int)tempR], mod-2);
						result %= mod;
						
						result *= zegob(factorial[(int)tempR], mod-2);
						result %= mod;
						
						n = n/mod;
						r = r/mod;
						
					}
				}
				
			}
			
			
			
			System.out.println(result);
	}
	
	
	public static long zegob(long num, int s) {
		if(s == 0) return 1;
		if(s == 1 ) return num;
		
		if(s%2==0) {
			long temp=zegob(num,s/2);
			return (temp%mod * temp%mod)%mod;
		}
		
		long temp = zegob(num, s-1)%mod;
		return ( num* temp ) %mod;
		
		
	}

}
