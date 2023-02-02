import java.util.*;
import java.io.*;

public class Main {

	public static int N, M, K, count = 0;
	public static int[][] board;
	public static Queue<XY> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				board[x][y] = 1;
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j] == 1) {
						queue.offer(new XY(i,j));
						count++;
						bfs();
					}
				}
			}
			
			
			
			
			sb.append(count+"\n");
			count = 0;
			
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			XY temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			
			board[x][y]++;
			
			for(int i=0;i<4;i++) {
				int tempX = x+dx[i];
				int tempY = y+dy[i];
				
				if(tempX >=0 && tempX <N && tempY>=0 && tempY <M) {
					if(board[tempX][tempY] == 1 ) {
						board[tempX][tempY]++;
						queue.offer(new XY(tempX, tempY));
					}
				}
			}
			
			
		}
	}

	
	public static class XY{
		int x;
		int y;
		XY(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
