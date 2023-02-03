import java.io.*;
import java.util.*;

public class Main {
	
	public static int r, c, result = 0;
	public static char[][] map;
	public static int[] dx = {-1,0,1};
	public static int[] dy = {1,1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<r;i++) {
			dfs(i,0);
		}
		
		System.out.println(result);
		
		br.close();

	}
	
	public static boolean dfs(int row, int col) {
		
		for(int i=0;i <3;i++) {
			int x = row + dx[i];
			int y = col + dy[i];
			
			if(x <0 || x>= r || y>=c) continue;
			if(map[x][y] == 'x') continue;
			
			map[x][y]='x';
			if(y == c-1) {
				result++;
				return true;
			}
			
			if(dfs(x,y)) {
				return true;
			}
		}
		return false;
	}
	
	
}