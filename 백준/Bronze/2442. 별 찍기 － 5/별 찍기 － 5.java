import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n;i++) {
			
			for(int j=1;j<n-i;j++) {
				sb.append(" ");
			}
			
			for(int j=0; j< (2*i) +1 ; j++) {
				sb.append("*");
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
