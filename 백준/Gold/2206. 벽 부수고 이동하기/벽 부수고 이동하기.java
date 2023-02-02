import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M, result = Integer.MAX_VALUE;
	public static int[][] board;
	public static Queue<XY> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String T = br.readLine();
			
			for(int j=0;j<M;j++) {
				String temp = T.substring(j,j+1);
				int num = Integer.parseInt(temp);
				board[i][j] = num;
			}
		}
		
		bfs();
		
				
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		
		System.out.println(result);
		
		
	}
	
	public static void bfs() {
		
		q.offer(new XY(0,0,1,0));
		boolean[][][] visit = new boolean[N][M][2];
		visit[0][0][0] = true;
		
		
		while(!q.isEmpty()) {
			XY temp = q.poll();
			int[] dx = {1,-1,0,0};
			int[] dy = {0,0,1,-1};
			
			if(temp.x == N-1 && temp.y==M-1) {
				result = Math.min(result, temp.count);
				q.clear();
				break;
			}
			
			for(int i=0;i<4;i++) {
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];
				
				if(x>=0 && x<N && y>=0 && y<M) {
					if(visit[x][y][temp.wall] == false) {
						visit[x][y][temp.wall] = true;
						if(board[x][y] == 0) {
							q.offer(new XY(x,y, temp.count+1, temp.wall));
						}
						if( board[x][y] == 1 && temp.wall < 1) {
							q.offer(new XY(x,y,temp.count+1, temp.wall+1));
						}
					}
				}
			}
		}
	}

	public static class XY {
		int x;
		int y;
		int count;
		int wall;
		
		XY(int x, int y, int count, int wall){
			this.x = x;
			this.y = y;
			this.count = count;
			this.wall = wall;
		}
	}
	
}
