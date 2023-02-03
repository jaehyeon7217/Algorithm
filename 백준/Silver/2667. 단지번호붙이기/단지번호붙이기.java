import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, count=1, result=0;
	public static int[][] map;
	public static ArrayList<Integer> list = new ArrayList<>();
	public static Queue<XY> q = new LinkedList<>();
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(map[i][j] == 1) {
					result++;
					count++;
					map[i][j] = count;
					q.offer(new XY(i,j));
					int tempCount = 0;
					while(!q.isEmpty()) {
						tempCount++;
						XY temp = q.poll();
						
						for(int k=0;k<4;k++) {
							int x = temp.x + dx[k];
							int y = temp.y + dy[k];
							
							if(x<0 || y<0 || x>=n || y>=n) continue;
							if(map[x][y] != 1) continue;
							
							map[x][y] = count;
							
							q.offer(new XY(x,y));
						}
						
					}
					list.add(tempCount);
				}
				
			}
		}
		
		Collections.sort(list);
		
		sb.append(result+"\n");
		for(Integer a : list) {
			sb.append(a+"\n");
		}
		
		System.out.println(sb);
		
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
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}