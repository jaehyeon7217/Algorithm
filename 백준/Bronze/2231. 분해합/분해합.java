import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m =0;
		int a1, a2, a3, a4, a5, a6;
		
		for(int i=1; i<1000000;i++) {
			a1 = i%10;
			a2 = (i%100)/10;
			a3 = (i%1000)/100;
			a4 = (i%10000)/1000;
			a5 = (i%100000)/10000;
			a6 = (i%1000000)/100000;
			if((i+a1+a2+a3+a4+a5+a6) == n ) {
				m=i;
				break;
			}
		}
		System.out.println(m);

	}

}
