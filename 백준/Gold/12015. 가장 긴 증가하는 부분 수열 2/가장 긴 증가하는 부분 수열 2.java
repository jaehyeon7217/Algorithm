import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size=0;
		
		for(int i=0;i<n;i++) {
			int pos = Arrays.binarySearch(dp, 0, size, arr[i]);
			if(pos>=0) {
				continue;
			}
			int insertPos = Math.abs(pos)-1;
			dp[insertPos] = arr[i];
			if(size== insertPos) {
				size++;
			}
			
		}
		
		System.out.println(size);
	}

}
