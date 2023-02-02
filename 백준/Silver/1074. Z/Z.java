import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, x, y, result = 0, count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2.0, n);
		
		dfs(0,0,size);
		
		System.out.println(result);
		
		br.close();

	}
	
	public static void dfs(int startX, int startY, int length) {
		if(length == 1) {
			result = count;
			return;
		}
		
		int size = length/2;
		
		int value = 1;
		
		loop: for(int i=1; i<=2; i++) {
			for(int j=1; j<=2;j++) {
				if( x <= startX + i*size-1 && y<=startY +j*size-1 ) {
					count += value-1;
					dfs(startX + (i-1)*size , startY + (j-1)*size, size);
					break loop;
				}
				value += (length*length)/4;
			}
		}
		
	}
	
}