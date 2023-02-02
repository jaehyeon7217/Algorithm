import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static int count = 0;
	public static int[] not;
	public static int[] ok;
	public static int tempSum=0;
	public static int min = 999999;
	public static int size;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		not = new int[M];
		
		String temp = String.valueOf(N);
		size= temp.length();
		
		int result = Math.abs(N-100);
		
		if(M == 0) {
			String a = String.valueOf(N);
			result = Math.min(result, a.length());
		}
		
		else {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< M; i++) {
				int t = Integer.parseInt(st.nextToken());
				not[i] = t;
			}
		
			for(int i=0; i< 890000 ; i++) {
				boolean tempBoolean = check(i);
				
				
				if(tempBoolean) {
					String a = String.valueOf(i);
					int size = a.length();
					
					int count = Math.abs(N-i);
					
					result = Math.min(result, (size+count));
					
				}
			}
			
		
		}
		
		System.out.println(result);
		br.close();
	}
	
	public static boolean check (int x) {
		String a = String.valueOf(x);
		int size = a.length();
		
		for(int i=1; i<=size;i++) {
			int t = x/ (int)(Math.pow(10, (double) size-i)) % 10;
			
			int tempSize = not.length;
			for(int j = 0; j<tempSize; j++) {
				if( t == not[j]) {
					return false;
				}
			}
		}
		
		return true;
		
	}

}
