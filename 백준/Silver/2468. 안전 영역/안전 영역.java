import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, result = 1, min=Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static int[][] map;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		for(int i=min;i<max;i++) {
			func(i);
		}
		
		System.out.println(result);
		
		br.close();
		
	}
	
	public static void func(int water) {
		
		boolean[][] check = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] <= water) {
					check[i][j] = true;
				}
			}
		}
		
		int count = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if (!check[i][j]) {
					count++;
					
					Queue<XY> q = new LinkedList<>();
					q.add(new XY(i, j));
					check[i][j] = true;
					while(!q.isEmpty()) {
						XY temp = q.poll();
						
						for(int k=0;k<4;k++) {
							int x = temp.x + dx[k];
							int y = temp.y + dy[k];
							
							if(x<0 || x>=n || y< 0 || y>= n) continue;
							if(check[x][y]) continue;
							
							q.add(new XY(x,y));
							check[x][y] = true;
						}
					}
					
				}
			}
		}
		result = Math.max(result,  count);
		
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
