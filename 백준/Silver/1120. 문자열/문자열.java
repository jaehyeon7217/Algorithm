
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		// ------------------------------------------------------------------------------

		st = new StringTokenizer(br.readLine(), " ");
		
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		
		int lengthX  = B.length - A.length;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<=lengthX; i++) {
			int count = 0;
			for(int j=0; j<A.length;j++) {
				if( B[i+j] != A[j] ) {
					count++;
				}
			}
			
			min = Math.min(count, min);
			
		}
		
		System.out.println(min);
		
		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();
	
		
	}

}
