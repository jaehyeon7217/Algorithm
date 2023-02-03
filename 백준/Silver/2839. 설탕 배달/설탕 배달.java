import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, result = -1, count=0;
	public static int[] sugar = {5,3};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		dfs(0);
		
		System.out.println(result);		
		
		br.close();

	}
	
	public static void dfs(int depth) {
		if(depth == 2) {
			if(n == 0) {
				if(result == -1) result = count; 
				else result = Math.min(result,  count);
			}
			return;
		}
		
		int temp = n/sugar[depth];
		
		for(int i=0;i<=temp;i++) {
			count += i;
			n -= i*sugar[depth];
			dfs(depth+1);
			n += i*sugar[depth];
			count -=i;
		}
		
	}


}