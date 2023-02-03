import java.util.*;
import java.io.*;

public class Main {
		public static int n,m, resultCount=0;
		public static int[] line;
		public static int[] result;
		public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		line = new int[n];
		result = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(line);
		
		check(m);

		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
	public static void check(int num) {
		if(num == 0) {
			for(int i=0;i<m;i++) 
				sb.append(result[i]+" ");
			sb.append("\n");
			return ;
		}
		
		for(int i=0;i<n;i++) {
			if(line[i] != 0) {
				int temp = line[i];
				result[resultCount++] = line[i];
				line[i] = 0;
				check(num-1);
				resultCount--;
				line[i] = temp;
			}
		}
	}
}