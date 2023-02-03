import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, m, count = 0;
	public static int[][] map;
	public static boolean[][] check;
	public static Queue<XY> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		while (true) {
		st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n == 0 && m == 0) break;
		
		map = new int[m][n];
		check = new boolean[m][n];
		count = 0;
		q = new LinkedList<>();
		
		for(int i=0 ;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n; j++) {
				if(map[i][j] == 1 && !check[i][j]) {
					check[i][j] = true;
					q.offer(new XY(i,j));
					count++;
					func();
				}
			}
		}
		
		sb.append(count + "\n");
		
		}
		
		System.out.println(sb.toString());
		
		br.close();
		

	}
	
	public static int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1};
	public static int[] dy = { 1, -1, 0, 1, -1, 0, 1, -1};
	
	public static void func() {
		
		while(!q.isEmpty()) {
			XY temp = q.poll();
			
			for(int i=0;i<8;i++) {
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];
				
				if(x<0 || x>=m || y<0 || y>=n || check[x][y] || map[x][y] == 0) continue;
				
				check[x][y] = true;
				q.offer(new XY(x,y));
				
			}
			
		}
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
