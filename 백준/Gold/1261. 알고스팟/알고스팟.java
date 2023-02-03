import java.io.*;
import java.util.*;

public class Main {
	
	public static int N, M;
	public static int[][] board;
	public static boolean[][] visit;
	public static PriorityQueue<XY> queue = new PriorityQueue<>();
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int result = Integer.MAX_VALUE;
	
   public static void main(String[] args) throws IOException {
	   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
	     
	   	M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		
		board = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			char[] c = s.toCharArray();
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(String.valueOf(c[j]));
			}
		}
		
		queue.offer(new XY(0,0,0));
		visit[0][0] = true;

		bfs();
		
		System.out.println(result);
		
   }
   
   public static void bfs() {
	   while(!queue.isEmpty()) {
		   XY temp = queue.poll();
		   
		   if(temp.x== N-1 && temp.y == M-1) {
			   result = temp.count;
			   queue.clear();
			   return;
		   }
		   
		   for(int i=0;i<4;i++) {
			   int x = temp.x + dx[i];
			   int y = temp.y + dy[i];
			   int c = temp.count;
			   
			   if(x>=0 && x<N && y>=0 && y<M) {
				   if(visit[x][y] == false && board[x][y] == 0) {
					   queue.offer(new XY(x,y,c));
					   visit[x][y] = true;
				   }
				   if(visit[x][y] == false && board[x][y] == 1) {
					   queue.offer(new XY(x,y,c+1));  
					   visit[x][y] = true;
				   }
				   }
			   }
		   }
	   }
   
   public static class XY implements Comparable<XY>{
		int x;
		int y;
		int count;
		
		XY(int x, int y){
			this.x = x;
			this.y = y;
		}
		XY(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
		@Override
		public int compareTo(XY a) {
			return this.count - a.count;
		}
	}
}