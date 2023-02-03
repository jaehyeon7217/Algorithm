import java.io.*;
import java.util.*;

public class Main {
	
	public static int n,m,v;
	public static boolean[][] map;
	public static boolean[] check;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		// 희소그래프 밀집 그래프
		
		map = new boolean[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = true;
			map[y][x] = true;
		}
		
		check = new boolean[n+1];
		dfs(v);
		
		sb.append("\n");
		check = new boolean[n+1];
		bfs(v);
		
		System.out.println(sb);

		br.close();

	}
	
	public static void dfs(int v) {
		
		check[v] = true;
		sb.append(v + " ");
		
		for(int i=1;i<n+1;i++) {
			if(map[v][i] && !check[i]) {
				dfs(i);
			}
		}
		
		return;
		
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		check[v] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x + " ");
			for(int i=1;i<n+1;i++) {
				if(map[x][i] && !check[i]) {
					q.offer(i);
					check[i] = true;
				}
			}
			
		}
		
		
	}


}