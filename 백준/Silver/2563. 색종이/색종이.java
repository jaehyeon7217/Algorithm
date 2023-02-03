import java.io.*;
import java.util.*;

public class Main {
	
	public static int size = 100, count=0;
	public static int[][] map;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[size][size];
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0 ;t<T;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x ; i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					map[i][j] = 1;
				}
			}
		}
		
		for(int i=0;i<size; i++) {
			for(int j=0 ;j<size;j++) {
				if(map[i][j] == 1) count++;
				
			}
		}
		
		
		System.out.println(count);
		
		
		
	}
}