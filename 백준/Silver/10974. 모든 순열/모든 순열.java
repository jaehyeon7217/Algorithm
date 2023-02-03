import java.util.*;
import java.io.*;

public class Main {

	public static int[] map;
	public static int[] result;
	public static int n;
	public static StringBuilder sb = new StringBuilder();

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		// ------------------------------------------------------------------------------

		n = Integer.parseInt(br.readLine());
		
		map = new int[n];
		result = new int[n];
		
		for(int i=0;i<n;i++) {
			map[i] = i+1;
		}
		
		func(0);

		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
	
	public static void func(int count) {
		if(count == n) {
			for(int i=0; i<n;i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(map[i] != 0) {
				int temp = map[i];
				result[count] = map[i];
				map[i] = 0;
				func(count+1);
				map[i] = temp;
			}
		}
		
	}
	

	
}