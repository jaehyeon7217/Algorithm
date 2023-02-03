
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
		
		String n = br.readLine();
		
		char[] chr = n.toCharArray();
		
		for(int i=0; i<chr.length; i++) {
			if(chr[i] >=97) {
				chr[i] -= 32; 
			}
			else chr[i] += 32;
			
			sb.append(chr[i]);
		}
		
		
		
		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();
	
		
	}
}