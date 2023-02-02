
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] lan;
	public static int k,n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		lan = new int[k];
		
		long min = 2147483647;
		long max = 0;
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			lan[i] = t;
			min = Math.min(min, t);
			max = Math.max(max, t);
		}
		
		
		sb.append(""+binarySearch(1L,max));
		
		bw.write(sb.toString());
		bw.close();
		

	}
	
	public static long binarySearch(long a, long b) {
		long first = a;
		long last = b;
		
		long mid = (first+last)/2;
		long result=0;
		while(first<=last) {
			long temp = check(mid);
			if(temp < n) {
				last = mid-1;
				mid = (first+last)/2;
			}
			else if(temp>= n) {
				result = mid;
				first = mid+1;
				mid = (first+last)/2;
			}
		}
		
		return result;
	}
	

	public static long check(long num) {
		long sum =0;
		for(int i=0; i<k;i++) {
			long temp = lan[i]/num;
			sum += temp;
		}
		
		return sum;
	}
	
}
