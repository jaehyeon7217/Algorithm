import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static int[][] board;
	public static Queue<XY> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String a = br.readLine();
			char[] b = a.toCharArray();
			for(int j=0;j<M;j++) {
				int t = b[j] - '0';
				board[i][j] = t;
			}
		}
		
		board[0][0] = 2;
		queue.offer(new XY(0,0));
		
		
		bfs();
		
		System.out.println(board[N-1][M-1]-1);
	}

	public static void bfs() {
		
		while(!queue.isEmpty()) {
			XY temp = queue.poll();
			int flag =0;
			int x = temp.x;
			int y = temp.y;
			
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			for(int i=0; i<4 ; i++) {
				int tempX = x+dx[i];
				int tempY = y+dy[i];
				
				if(tempX == N && tempY == M) {
					while(!queue.isEmpty()) {
						queue.poll();
					}
					break;
				}
				
				if(tempX>=0 && tempX<N && tempY>= 0 && tempY<M) {
					if(board[tempX][tempY] == 1) {
						flag = 1;
						queue.offer(new XY(tempX, tempY));
						board[tempX][tempY] = board[x][y] +1;
						
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
