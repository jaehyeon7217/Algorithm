import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] a = new Integer[N];
		int[] b = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N; i++) {
			int s = Integer.parseInt(st.nextToken());
			a[i] = s;
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N; i++) {
			int s = Integer.parseInt(st.nextToken());
			b[i] = s;
		}
		
		Arrays.sort(a, Collections.reverseOrder());
		Arrays.sort(b);
		
		int sum = 0;
		
		for(int i=0; i<N;i++) {
			sum += a[i]*b[i];
		}
		
		System.out.println(sum);

	}

}
