
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
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		sb.append(a+b);

		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();
	
		
	}

}
