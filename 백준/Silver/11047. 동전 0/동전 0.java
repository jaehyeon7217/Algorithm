import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		int size = 0;
		int count = 0;
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			
			if(K>=t) {
				coin[i]= t;
				size= i;
			}
		}
		
		for(int i=size; i>=0; i--) {
			if(coin[i] != 0) {
				int temp = K/coin[i];
				K -= (temp*coin[i]);
				count += temp;
			}
			
			if(K == 0) {
				break;
			}
		}
		
		System.out.println(count);
		

	}

}
