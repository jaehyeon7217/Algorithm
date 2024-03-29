import java.io.*;
import java.util.*;

public class Main {
	public static int n, d, k, c, size=0, result = 0, sum = 0;
	public static int[] map;
	public static int[] sushi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[n];
		sushi = new int[d+1];
		
		
		for(int i=0;i<n;i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i= 0 ; i<n+k-1;i++) {
			int index = i%n;
			
			if(size<k) {
				size++;
				sushi[map[index]]++;
				if( sushi[map[index]] == 1) sum++;
				
			}else {
				sushi[map[(i-k)%n]]--;
				if(sushi[map[(i-k)%n]] == 0) sum--;
				
				sushi[map[index]]++;
				if( sushi[map[index]] == 1) sum++;
			}
			
			if(size == k) {
				if(sushi[c] == 0)
					result = Math.max(result, sum+1);
				else
					result = Math.max(result, sum);
				
			}
			
		}
		
		System.out.println(result);
		
		
	}
	
}
