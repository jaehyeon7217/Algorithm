
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

		String a = br.readLine();
		
		char[] c = a.toCharArray();
		
		int count = 0;
		
		boolean f = true;
		
		for(int i = 0; i<c.length ; i++) { 
			if(f) {
				if(c[i] != ' ') {
					count++;
					f = false;
				}
			}
			else {
				if(c[i] == ' ') f= true;
			}
		}
		
		sb.append(count);
		
		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();
	
		
	}

}
