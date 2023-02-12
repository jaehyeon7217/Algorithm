import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static int[][][] board;
	public static Queue<Tomato> tomato = new LinkedList<>();
	public static int m,n,h;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		board = new int[h][n][m];
		int zeroFlag = 0;
		for(int i=0; i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {
					int temp = Integer.parseInt(st.nextToken());
					board[i][j][k] = temp;
					
					if(temp == 1) {
						tomato.offer(new Tomato(k,j,i));
					}
					
					else if(temp == 0) {
						zeroFlag++;
					}
					
				}
			}
		}
		
		if(zeroFlag == 0) {
			sb.append("0\n");
			bw.write(sb.toString());
			bw.close();
			System.exit(0);
		}
		
		sb.append(bfs());
		bw.write(sb.toString());
		bw.close();
		

	}

	public static int bfs() {
		int x,y,z;
		
		int[] temp_x = {-1,1,0,0,0,0};
		int[] temp_y = {0,0,-1,1,0,0};
		int[] temp_z = {0,0,0,0,-1,1};
		
		
		while(!tomato.isEmpty()) {
			Tomato t = tomato.poll();
			
			for(int i = 0; i<6; i++) {
				x= t.x + temp_x[i];
				y= t.y + temp_y[i];
				z= t.z + temp_z[i];
				
				if(x>=0 && x<m && y>=0 && y<n && z>=0 && z<h) {
					if(board[z][y][x] == 0) {
						board[z][y][x] = board[t.z][t.y][t.x] + 1;
						tomato.offer(new Tomato(x,y,z));
					}	
				}
				
			}
		}
		
		int result = 2;
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(board[i][j][k] == 0) {
						return -1;
					}
					result = Math.max(result, board[i][j][k]);
				}
			}
		}
		
		
		return result -1;
	}
	
	
	public static class Tomato{
		int x;
		int y;
		int z;
		
		public Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void view() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					System.out.print(board[i][j][k] + " ");
				}
				System.out.println("");
			}
		}
	}
}
