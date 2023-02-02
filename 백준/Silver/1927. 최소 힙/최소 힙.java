import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			int t = Integer.parseInt(br.readLine());
			if(t == 0) {
				if(heap.isEmpty()) {
					sb.append("0\n");
				}
				else {
					sb.append(heap.poll()+"\n");
				}
			}
			else {
				heap.offer(t);
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
