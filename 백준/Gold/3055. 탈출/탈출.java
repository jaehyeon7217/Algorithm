import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, m;
	public static char[][] map;
	public static Queue<XY> Sq = new LinkedList<>();
	public static Queue<XY> Tq = new LinkedList<>();
	public static Queue<XY> Wq = new LinkedList<>();
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0;j<m;j++) {
				if(map[i][j] == 'S') Sq.offer(new XY(i,j));
				if(map[i][j] == '*') Wq.offer(new XY(i,j));
			}
		}
		int count=0;
		boolean flag = true;
		while(flag) {
			count++;
			
			if(Sq.isEmpty()) {
				flag = false;
				count = -1;
				break;
			}
			
			while(!Wq.isEmpty()) {
				XY temp = Wq.poll();
				
				for(int i=0;i<4;i++) {
					int x = temp.x + dx[i];
					int y = temp.y + dy[i];
					
					if(x<0|| y<0 || x>=n || y>=m) continue;
					if(map[x][y] == '.' || map[x][y] == 'S') {
						map[x][y] = '*';
						Tq.offer(new XY(x,y));
					}
				}
			}
			
			while(!Tq.isEmpty()) Wq.offer(Tq.poll());
			
			while(!Sq.isEmpty()) {
				XY temp = Sq.poll();
				
				for(int i=0;i<4;i++) {
					int x = temp.x + dx[i];
					int y = temp.y + dy[i];
					
					if(x<0|| y<0 || x>=n || y>=m) continue;
					if(map[x][y] == 'D') {
						flag = false;
						break;
					}
					if(map[x][y] == '.') {
						map[x][y] = 'S';
						Tq.offer(new XY(x,y));
					}
				}
			}
			while(!Tq.isEmpty()) Sq.offer(Tq.poll());
		}
		
		if(count == -1) System.out.println("KAKTUS");
		else System.out.println(count);
		
		
		br.close();
	}
	
	public static class XY{
		int x;
		int y;
		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void pr() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}