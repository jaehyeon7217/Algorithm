import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, m, zeroCount = 0, count=0, result=1;
	public static int[][] map;
	public static Queue<XY> q = new LinkedList<>();
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.offer(new XY(i,j));
				if(map[i][j] == 0) zeroCount++;
			}
		}
		
		while(!q.isEmpty()) {
			
			XY temp = q.poll();
			
			for(int i=0; i<4;i++) {
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];
				
				if(x<0 || y<0 || x>=n || y>=m) continue;
				if(map[x][y] != 0)continue;
				
				map[x][y] = map[temp.x][temp.y] + 1;
				count++;
				
				q.offer(new XY(x,y));
				
				result = Math.max(result, map[x][y]);
				
			}
			
			
		}
		if(zeroCount - count >0) result = 0;
		
		System.out.println(result-1);
		
		
		br.close();
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
	
	public static void pr() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}