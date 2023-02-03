import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		
		int count = 0;
		for(int i=0; i <N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int v = Integer.parseInt(br.readLine());
		
		for(int i=0; i <N; i++) {
			if(num[i] == v) count++;
		}
		
		System.out.println(count);
		br.close();		
		
	}

}
