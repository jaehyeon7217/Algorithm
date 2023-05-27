import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Queue<Node> q = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i<m ; i++) { 
			int temp = Integer.parseInt(st.nextToken());
			check[temp] = true;
			q.offer(new Node(temp,0));
		}
		
		int result = 0;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			// 2의 20승은 100만을 초과한다.
			for(int i=0;i<20;i++) {
				int a = 1<<i;
				if(a > n) break;
				
				a = temp.x^a;
				if(a<=n && !check[a]) {
					check[a] = true;
					result = Math.max(temp.count+1, result);
					q.offer(new Node(a, temp.count+1));
				}
			}
		}
		
		
		System.out.println(result);
		
		br.close();
	}
	
	public static class Node{
		int x;
		int count;
		public Node(int x, int count) {
			super();
			this.x = x;
			this.count = count;
		}
		
	}

}

