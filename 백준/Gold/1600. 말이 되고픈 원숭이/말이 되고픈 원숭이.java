import java.util.*;
import java.io.*;

public class Main {

	public static int n,m,k, result = -1;
	public static int[][] map;
	public static boolean[][][] check;
	public static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		check = new boolean[n][m][k+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new int[]{0, 0, 0, 0});
		check[0][0][0] = true;
		
//		int[] dx = {0,0,1,-1};
//		int[] dy = {1,-1,0,0};
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
//		int[] hx = {-2, -1, -2, -1, 1, 2, 1, 2};
//		int[] hy = {-1, -2, 1, 2, -2, -1, 2, 1};
		
		int[] hx = {1,2,2,1,-1, -2, -2, -1};
		int[] hy = {2,1,-1,-2, 2, 1, -1, -2};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(temp[0] == n-1 && temp[1] == m-1) {
				result = temp[3];
				q.clear();
				break;
			}
			
			if(temp[2]<k) {
				for(int i=0;i<8;i++) {
					int x = temp[0] + hx[i];
					int y = temp[1] + hy[i];
					
					if(x<0 || y<0 || x>= n || y>= m) continue;
					if(map[x][y] != 0) continue;
					if(check[x][y][temp[2]+1]) continue;
					
					check[x][y][temp[2]+1] = true;
					q.offer(new int[] {x,y,temp[2]+1,temp[3]+1});
				}
			}
			
			for(int i=0;i<4;i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				
				if(x<0 || y<0 || x>= n || y>= m) continue;
				if(map[x][y] != 0) continue;
				if(check[x][y][temp[2]]) continue;
				
				check[x][y][temp[2]] = true;
				q.offer(new int[] {x,y,temp[2],temp[3]+1});
			}
		}
		
		System.out.println(result);
		
		
	}
}
