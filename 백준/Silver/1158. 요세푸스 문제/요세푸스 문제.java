import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			list.add(i+1);
		}
		
		int temp = k-1;
		sb.append("<");
		for(int i=0; i<n-1;i++) {
			sb.append(list.get(temp) +  ", ");
			list.remove(temp);
			temp = (temp-1+k)%(list.size());
		}
		
		sb.append(list.get(0) + ">");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
}
