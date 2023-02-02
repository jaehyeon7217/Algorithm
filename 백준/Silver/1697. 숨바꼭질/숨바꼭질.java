import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, K, result;
	public static Queue<node> q = new LinkedList<>();
	public static boolean[] visit = new boolean[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(result);
	}
	
	public static void bfs() {
		q.offer(new node(N,0));
		visit[N] = true;
		
		while(!q.isEmpty()) {
			node n = q.poll();
			
			if(n.index == K) {
				result = n.count;
				q.clear();
				break;
			}
			
			if( n.index - 1 >= 0 && visit[n.index-1] == false) {
				q.offer(new node(n.index -1, n.count+1));
				visit[n.index-1] = true;
			}
			
			if(n.index < K) {
				
				if( n.index + 1 <= 100000 && visit[n.index + 1] == false) {
					q.offer(new node(n.index + 1, n.count+1));
					visit[n.index + 1] = true;
				}
				if( n.index * 2 <= 100000 && visit[n.index*2] == false) {
					q.offer(new node(n.index * 2, n.count+1));
					visit[n.index * 2] = true;
				}
			}
			
		}
		
	}
	
	public static class node{
		int index;
		int count;
		
		node(int index, int count){
			this.index = index;
			this.count = count;
		}
	}
}
