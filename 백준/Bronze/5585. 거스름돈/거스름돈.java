import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] coin = {500, 100, 50, 10, 5, 1};
		
		int k = 1000-n;
		int count=0;
		
		for(int i=0;i<6;i++){
			int temp = k/coin[i];
			if(temp != 0) {
				k -= temp*coin[i];
				count += temp;
			}
			
			if(k == 0) {
				break;
			}
		}
		
		System.out.println(count);

	}

}
