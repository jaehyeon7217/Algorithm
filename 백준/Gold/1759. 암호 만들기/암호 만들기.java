import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, m;
	public static char[] map;
	public static int[] check = new int[2];
	public static char[] result, mo = { 'a', 'e', 'i', 'o', 'u'};
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new char[n];
		map = new char[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<m;i++) {
			map[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(map);
		
		dfs(0,0);
		
		System.out.println(sb);
		
		br.close();
	}
	
	public static void dfs(int depth, int start) {
		if(depth == n) {
			if( check[0] >0 && check[1] >1) {
				sb.append(String.valueOf(result) + "\n");
			}
			return;
		}
		
		for(int i=start;i<m;i++) {
			result[depth] = map[i];
			
			boolean flag = true;
			for(int j=0; j<5; j++) {
				if(map[i] == mo[j]) {
					check[0]++;
					flag = false;
					break;
				}
			}
			if(flag) check[1]++;
			
			dfs(depth+1, i+1);
			
			if(flag) check[1]--;
			else check[0]--;
			
		}
		
	}
	
}