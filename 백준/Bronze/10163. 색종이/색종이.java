import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[1002][1002];
		int[] count = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int x = x1 ; x<x1+w ; x++) {
				for(int y= y1; y<y1+h; y++) {
					board[x][y] = i+1;
				}
			}
		}
		for(int i= 0; i<1002;i++) {
			for(int j=0;j<1002;j++) {
					if(board[i][j] != 0) {
						count[board[i][j]-1]++;
					}
			}
		}
		for(int k = 0; k<N ; k++) {
			sb.append(count[k]+"\n");
		}
		
		bw.write(sb.toString());
		bw.close();
	}

}
