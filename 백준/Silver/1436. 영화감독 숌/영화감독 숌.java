
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static long[] number;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		number = new long[n];
		
		int flag = 0;
		int i=665;
		while(flag < n && i < 2147483647) {
			String temp = String.valueOf(i);
			int size = temp.length();
			char[] check = new char[size];
			check = temp.toCharArray();
			for(int j=0;j<size-2;j++) {
				if(check[j] == '6' && check[j+1] == '6' && check[j+2] == '6') {
					number[flag++] = i;
					break;
				}
			}
			i++;
		}
		sb.append(""+number[n-1]);
		bw.write(sb.toString());
		bw.close();
		
		
	}
	
	
	

}
