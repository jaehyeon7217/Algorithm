import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int a=0; a<T;a++) {
			st= new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			Queue<printer> queue = new LinkedList<>();
			Integer[] priority = new Integer[N];
			
			st= new StringTokenizer(br.readLine(), " ");
			for(int i =0 ; i<N ; i++) {
				int t = Integer.parseInt(st.nextToken());
				queue.offer(new printer(i, t));
				priority[i] = t;
			}
			Arrays.sort(priority, Collections.reverseOrder());
			
			int count = 0;
			boolean flag = true;
			while(!queue.isEmpty() && flag) {
				printer temp = queue.poll();
				if( temp.p == priority[count]) {
					if(temp.v == Q) {
						flag = false;
						sb.append((count+1) + "\n");
					}
					count++;
				}
				else if( temp.p != priority[count]) {
					queue.offer(temp);
				}
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		

	}
	
	public static class printer{
		int v;
		int p;
		
		printer(int v, int p){
			this.v = v;
			this.p = p;
		}
	}
}
