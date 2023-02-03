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
		StringTokenizer st;
		
		int[][] map = new int[19][19];
		
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<19;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		
		int resultX = 0;
		int resultY = 0;
		
		loop : for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j] != 0){
					
					int n = map[i][j];
					
					// 시작 위치 잡기
					
					int[] dx = {-1, 0, -1, -1};
					int[] dy = {0, -1, -1, 1};
					
					for(int a = 0 ; a<4; a++) {
						int x = i;
						int y = j;
						while(true) {
							x = x + dx[a];
							y = y + dy[a];
							if(x<0 || y<0 || x>=19 || y>= 19 || (map[x][y] != n) ) {
								x = x - dx[a];
								y = y - dy[a];
								break;
							}
							
						}
						int count = 1;
						int tempX = x;
						int tempY = y;
						
						while(true) {
							x = x - dx[a];
							y = y - dy[a];
							if(x<0 || y<0 || x>=19 || y>= 19 || (map[x][y] != n) ) break;
							
							count++;
						}
						
						if(count == 5) {
							result = n;
							
							if(a == 3) {
								resultX = x+dx[3]+1;
								resultY = y+dy[3]+1;
							}else {
								resultX = tempX+1;
								resultY = tempY+1;
							}
							break loop;
						}
						
					}
					
				}
			}
		}
		if(result != 0)	sb.append(result + "\n" + resultX + " " + resultY);
		if(result == 0) sb.append(result);
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
