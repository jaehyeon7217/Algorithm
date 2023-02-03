import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] number = new int[N];
		
		for(int i=0; i<N ; i++) {
			int t = Integer.parseInt(br.readLine());
			number[i] = t; 
		}
		
		Arrays.sort(number);
		
		for(int i=0; i<N ; i++) {
			sb.append(number[i]+"\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
