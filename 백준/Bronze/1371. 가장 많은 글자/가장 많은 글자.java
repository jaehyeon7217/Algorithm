
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

		int[] alpha = new int[26];
		
		String temp;
		while((temp = br.readLine()) != null  ) {
			
			
			char[] chr = temp.toCharArray();
			
			for(int i=0; i<chr.length; i++) {
				if(chr[i] != ' ')	alpha[chr[i]-'a']++;
			}
			
		}
		
		int max = -1;
		int count = 0;
		
		for(int i=0;i<alpha.length; i++) {
			max = Math.max(max,  alpha[i]);
		}
		
		for(int i=0;i<alpha.length; i++) {
			if(alpha[i]==max) {
				sb.append( (char)(i+'a') );
			}
			
		}
		
		
		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();
	
		
	}

}
