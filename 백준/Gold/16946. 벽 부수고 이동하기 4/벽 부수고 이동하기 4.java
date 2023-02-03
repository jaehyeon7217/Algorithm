import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static int[][] board;
	public static Queue<XY> q = new LinkedList<>();
	public static LinkedList<XY> one = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];

		for(int i=0;i<N;i++) {
			String a = br.readLine();
			for(int j=0;j<M;j++) {
				String b = a.substring(j,j+1);
				board[i][j] = Integer.parseInt(b);
				
				if(board[i][j] == 1) board[i][j] = -1;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 0) {
					bfs(i,j);
				}
			}
		}
		
		int[] cnt = new int[count+1];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] != -1) {
					cnt[board[i][j]]++;
				}
			}
		}
		
		//for(int i = 0;i<count+1;i++) {
		//	System.out.print(cnt[i]);
		//}
		
		//view();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int temp=0;
				if(board[i][j] == -1) {
					
					boolean[] visit = new boolean[count+1];
					
					int[] dx = {1,-1,0,0};
					int[] dy = {0,0,1,-1};
					
					for(int k=0; k<4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						
						if(x<0 || x>=N || y<0 || y>= M) continue;
						
						if( board[x][y] != -1 && visit[board[x][y]] == false) {
							temp += cnt[board[x][y]];
							visit[board[x][y]] = true;
						}
					}
					sb.append((temp+1)%10);
				}
				else {
					sb.append((temp));
				}
					
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
		
	}
	
	public static void bfs(int sx, int sy) {
		
		q.offer(new XY(sx, sy));
		
		count++;
		
		board[sx][sy] = count;
		
		while(!q.isEmpty()) {
			XY t = q.poll();
			
			int[] dx = {1,-1,0,0};
			int[] dy = {0,0,1,-1};
			
			for(int i=0; i<4; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				
				if(x<0 || x>=N || y<0 || y>= M) continue;
				
				if( board[x][y] == 0) {
					q.offer(new XY(x,y));
					board[x][y] = count;
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
	
	public static void view() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
					System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
}
