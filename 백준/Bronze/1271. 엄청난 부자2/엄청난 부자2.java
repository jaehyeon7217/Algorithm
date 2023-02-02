import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String n = st.nextToken();
		String m = st.nextToken();
		
		BigInteger a = new BigInteger(n);
		BigInteger b = new BigInteger(m);
		
		sb.append(a.divide(b)+"\n");
		sb.append(a.remainder(b));
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
		
	}

}
