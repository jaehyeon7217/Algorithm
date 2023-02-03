
import java.util.*;
import java.io.*;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		// ------------------------------------------------------------------------------
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] num = new int[3];
		
		for(int i=0;i<3;i++) {
			num[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(num);
		
		for(int i=0;i<3;i++) {
			sb.append(num[i]+ " ");
		}

		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();
	
		
	}

}
