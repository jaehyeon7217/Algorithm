import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer> sosu = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int end = (int)Math.sqrt((double)M);
		int size = 0;
		sosu.add(2);
		
		for(int i=3; i<=M+1 ; i++) {
			size = sosu.size();
			for(int j=0;j<=size; j++) {
				if(j==size) {
					sosu.add(i); 
					break;
				}
				if(sosu.get(j)>end) {
					sosu.add(i); 
					break;
				}

				else if( (i%sosu.get(j) == 0)) {
					break;
				}
				
			}
			
		}
		
		
		
		for(int i=0 ;i< size ; i++ ) {
			if(sosu.get(i)>=N) {
				sb.append(String.valueOf(sosu.get(i)+"\n"));
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
