import java.io.*;
import java.util.*;

public class Main {

	public static long n, m, count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		
		for(int T=0;T<t;T++) {
			count = 1;
			st = new StringTokenizer(br.readLine(), " ");
			n = Long.parseLong(st.nextToken());
			m = Long.parseLong(st.nextToken());		
			
			// mCn
			long mul = m;
			long di = 1;
			for(long i=m;i>m-n ;i--) {
				count *= mul--;
				count /= di++;
			}
			
			
			sb.append(count + "\n");
		}
		

		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}