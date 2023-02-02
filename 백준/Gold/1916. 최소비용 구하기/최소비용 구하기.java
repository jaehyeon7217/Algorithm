import java.util.*;
import java.io.*;

public class Main {

	public static ArrayList<ArrayList<root>> city = new ArrayList<>();
	public static int[] cost;
	public static boolean[] visit;
	public static int N, M, start, end;
	public static PriorityQueue<root> queue = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1];
		visit = new boolean[N+1];
		for(int i=0; i<=N;i++) {
			city.add(new ArrayList<>());
			cost[i] = 987654321;
		}
		
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) ;
			int n2 = Integer.parseInt(st.nextToken()) ;
			int c = Integer.parseInt(st.nextToken());
			
			city.get(n1).add(new root(n2, c));
			
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) ;
		end = Integer.parseInt(st.nextToken()) ;
		
		queue.offer(new root(start, 0));
		cost[start] = 0;
		
		while(!queue.isEmpty()) {
			root temp = queue.poll();
			
			if(!visit[temp.node]) {
			visit[temp.node] = true;
			
				int size = city.get(temp.node).size();
				
				for(int i=0; i<size; i++) {
					root tempR = city.get(temp.node).get(i);
						if( cost[tempR.node] > cost[temp.node] + tempR.cost) {
						
							cost[tempR.node] = cost[temp.node] + tempR.cost; 
						
							queue.offer(new root( tempR.node, cost[tempR.node]));
						}
				}
			}
		}
		
		System.out.println(cost[end]);
		
		
	}

	public static class root implements Comparable<root>{
		int node;
		int cost;
		
		root(int a, int cost){
			this.node = a;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(root a) {
			return cost - a.cost;
		}
	}
}
