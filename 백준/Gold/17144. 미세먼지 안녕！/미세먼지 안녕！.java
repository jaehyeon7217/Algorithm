import java.io.*;
import java.util.*;

import javax.sound.midi.Soundbank;

public class Main {
	
	public static int r,c,t, result = 0;
	public static int[][] map;
	public static XY[] air = new XY[2];
	public static Queue<XY> q = new LinkedList<>();
	public static int[] dx = {0,-1,0,1};
	public static int[] dy = {1,0,-1,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		int airCount=0;
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) air[airCount++] = new XY(i,j,-1);
				
			}
		}
		
		for(int C=0;C<t;C++) {
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(map[i][j] != 0) q.offer(new XY(i,j, map[i][j]));
				}
			}
			
			while(!q.isEmpty()) {
				XY temp = q.poll();
				
				int count = 0;
				
				for(int i=0;i<4;i++) {
					int x = temp.x + dx[i];
					int y = temp.y + dy[i];
					
					if(x<0 || x>=r || y<0 || y>=c) continue;
					if(map[x][y] == -1) continue;
					
					count++;
					map[x][y] += temp.count/5;
					
				}
				
				map[temp.x][temp.y] -= count*(temp.count/5);
			}
			

			for(int i= 0;i<2;i++) {
				int value = 0;
				int x = air[i].x;
				int y = air[i].y;
				
				for(int j=0;j<4;j++) {
					int index = j;
					if(i==1 && (j == 1 || j ==3)) {
						index = j==1 ? 3 : 1;
					}
					
					
					while(true) {
						x += dx[index];
						y += dy[index];
						
						
						if(x < 0 || x>=r || y<0 || y>=c) {
							x -= dx[index];
							y -= dy[index];
							break;
						}
						if(map[x][y] == -1) break;
						
						int temp = map[x][y];
						map[x][y] = value;
						value = temp;
					}
				}
			}
			
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j] != -1) result += map[i][j];
			}
		}
		
		System.out.println(result);
		
		br.close();

	}

	public static class XY{
		int x;
		int y;
		int count=0;
		public XY(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void pr() {
		for(int i=0;i<r;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}
}
