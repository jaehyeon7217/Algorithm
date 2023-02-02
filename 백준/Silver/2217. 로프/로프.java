import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] rope = new int[N];
		
		for(int i=0; i<N; i++) {
			int t = Integer.parseInt(br.readLine());
			rope[i] = t;
		}
		
		Arrays.sort(rope);
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N;i++) {
			max = Math.max(max, rope[i]*(N-i));
		}

		System.out.println(max);
	}

}
