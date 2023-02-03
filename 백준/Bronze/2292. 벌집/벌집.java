import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int sum=0;
		int temp=0;
		int flag=0;
		
		for(int i=0;i<18258;i++) {
			sum += i;
			temp = 6*sum + 1;
			if(n<=temp) {
				flag = i;
				break;
			}
			
		}
		
		System.out.println(flag+1);
		

	}

}
