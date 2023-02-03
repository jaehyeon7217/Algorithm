import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, result = Integer.MAX_VALUE;
	public static int[][] map;
	public static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		check = new boolean[n];
		
		for(int i=0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0);
		
		System.out.println(result);
		br.close();

	}
	
	public static void func(int depth, int start) {
		if(depth == n/2) {
			int[] a = new int[depth];
			int[] b = new int[depth];
			
			int aCount = 0, bCount=0;
			int aSum = 0, bSum=0;
			
			for(int i=0;i<n;i++) {
				if(check[i]) a[aCount++] = i;
				if(!check[i]) b[bCount++] = i;
			}
			
			for(int i=0;i<depth-1; i++) {
				for(int j=i+1;j<depth;j++) {
					aSum += map[a[i]][a[j]] + map[a[j]][a[i]];
					bSum += map[b[i]][b[j]] + map[b[j]][b[i]];
				}
			}
			
			result = Math.min(Math.abs(aSum-bSum), result);
			
			return;
		}
		
		for(int i=start; i<n;i++) {
			
			check[i] = true;
			func(depth+1, i+1);
			check[i] = false;
			
		}
		
		
	}

}
