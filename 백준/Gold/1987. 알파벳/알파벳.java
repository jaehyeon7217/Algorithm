import java.io.*;
import java.util.*;

public class Main {

	public static int n,m, alphabetCount = 26, count = 1, result = 1;
	public static char[][] map;
	public static boolean[][] check;
	public static boolean[] alphabet = new boolean[alphabetCount];
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		check = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		check[0][0] = true;
		alphabet[ map[0][0] - 'A' ]=true;
		dfs(0,0);
		
		
		
		System.out.println(result);
		
		br.close();

	}
	
	public static void dfs(int X, int Y) {
		
		for(int i=0;i<4;i++) {
			int x = X + dx[i];
			int y = Y + dy[i];
			
			if(x<0||x>=n||y<0||y>=m) continue;
			if(check[x][y] || alphabet[ map[x][y] - 'A']) continue;
			
			check[x][y] = true;
			alphabet[ map[x][y] - 'A'] = true;
			result = Math.max(result, ++count);
			dfs(x,y);
			count--;
			alphabet[ map[x][y] - 'A'] = false;
			check[x][y] = false;
		}
		
		return;
		
		
	}
	
	
	
	public static class XY{
		int x;
		int y;
		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
}
