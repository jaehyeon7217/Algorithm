import java.io.*;
import java.util.*;

public class Main {
	
	public static int n;
	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		
		dfs(0,0,n);
		
		System.out.println(sb);

		br.close();

	}
	
	public static void dfs(int startX, int startY, int length) {
		if(length == 1) {
			sb.append(map[startX][startY]);
			return;
		}
		
		int temp = map[startX][startY];
		boolean flag = true;
		loop : for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(map[startX+i][startY+j] != temp ) {
					flag = false;
					break loop;
				}
			}
		}
		
		if(flag) {
			sb.append(temp);
			return;
		}
		
		sb.append("(");
		int size = length/2;
		dfs(startX,startY,size);
		dfs(startX,startY+size,size);
		dfs(startX+size,startY,size);
		dfs(startX+size,startY+size,size);
		sb.append(")");
		
		
		
	}

}
