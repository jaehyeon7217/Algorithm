
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
		
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				int temp = -1;
				while(true) {
					temp += number;
					if(temp>= n) break;
					num[temp] = (num[temp] + 1)%2;
				}
			}
			else  {
				int temp = number-1;
				int x = temp;
				int y = temp;
				num[temp] = (num[temp] + 1)%2;
				while(true) {
					x += 1;
					y -= 1;
					
					if(x>=n || y<0) break;
					
					if(num[x] == num[y]) {
						num[x] = (num[x] + 1)%2;
						num[y] = (num[y] + 1)%2;
					}
					else break;
				}
			}
			
		}
		for(int i=0 ; i< n;i++) {
			sb.append(num[i] + " ");
			
			if(i%20 == 19) sb.append("\n");
		}
				
				
		// -----------------------------------------------------------------------------Main
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
}