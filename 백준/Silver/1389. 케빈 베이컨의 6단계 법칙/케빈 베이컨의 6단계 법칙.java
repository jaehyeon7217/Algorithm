import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static Node[] node;
	public static PriorityQueue<Node> queue = new PriorityQueue<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		node = new Node[N];
		
		for(int i=0;i<N;i++) node[i] = new Node(i+1);
		
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken())-1;
			int t2 = Integer.parseInt(st.nextToken())-1;
			
			node[t1].offer(node[t2]);
			node[t2].offer(node[t1]);			
		}
		
		int min= Integer.MAX_VALUE;
		int minIndex =0;
		
		for(int i=0;i<N;i++) {
			int sum =0;
			for(int j=0;j<N;j++) {
				if(i != j) {
					sum += bfs(i, j);
				}
			}
			if(min>sum) {
				min = sum;
				minIndex = i+1;
			}
			if(min == sum) {
				minIndex = Math.min(minIndex,  i+1);
			}
		}
		System.out.println(minIndex);
		
	}
	
	public static int bfs(int a, int b) {
		reset();
		queue.offer(node[a]);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if(temp.index == b+1) {
				queue.clear();
				return temp.count;
			}
			
			if(!temp.child.isEmpty()) {
				for(int i=0;i<temp.size;i++) {
					Node next = temp.child.get(i);
					if(next.count == 0) {
						next.count = temp.count + 1;
						queue.offer(next);
					}
				}
			}
			
		}
		return 0;
	}

	public static void reset() {
		for(int i=0;i<N;i++) {
			node[i].reset();
		}
	}
	
	public static class Node implements Comparable<Node>{
		LinkedList<Node> child = new LinkedList<>();
		int index;
		int size=0;
		int count =0;
		
		Node(int x){
			this.index = x;
		}
		
		public void offer(Node x){
			this.child.offer(x);
			this.size = child.size();
		}
		
		public void reset() {
			this.count =0;
		}
		
		@Override
		public int compareTo(Node a) {
			return this.count - a.count;
		}
	}
}

