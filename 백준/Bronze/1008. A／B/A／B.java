
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

		st= new StringTokenizer(br.readLine(), " ");
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		
		sb.append(a/b);
		
		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();
	
		
	}

}
