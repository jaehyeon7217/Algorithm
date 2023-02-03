import java.io.*;
import java.util.*;

public class Main {
		public static int n,m;
		public static int[] line;
		public static int[] result;
		public static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        
		// ------------------------------------------------------------------------------
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
		
		check(m, "", 0);
		Object[] tempObj = set.toArray();
		
		for(int i=0;i<tempObj.length; i++) {
			sb.append((String)tempObj[i]).append("\n");
		}

		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
	public static void check(int num, String s, int st) {
		if(num == 0) {
			set.add(s);
			return ;
		}
		
		for(int i=st;i<n;i++) {
			if(line[i] != 0) {
				int temp = line[i];
				check(num-1, s+temp+" ", i);
				line[i] = temp;
			}
		}
		
		
		
	}
	
}