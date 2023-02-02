import java.util.*;
import java.io.*;

public class Main {
	
	public static Node[] node;
	public static int count=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		node = new Node[N];
		for(int i=0; i<N; i++) {
			node[i] = new Node();
		}
		int startIndex = 0;
		
		st= new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t == -1) {
				startIndex = i;
			}
			else {
				node[t].addNode(node[i]);
			}
		}
		int X = Integer.parseInt(br.readLine());
		
		if(X == startIndex) {
			System.out.println("0");
			br.close();
			System.exit(0);
		}
		
		for(int i=0; i<N;i++) {
			if(node[i].child.contains(node[X])) {
				node[i].deleteNode(node[X]);
			}
		}
		
		dfs(node[startIndex]);
		
		System.out.println(count);
		
	}
	
	public static void dfs(Node x) {
		if( x.child.isEmpty()) {
			count++;
			return;
		}
		
		else if(!x.child.isEmpty()) {
			int size = x.child.size();
			
			for(int i=0; i<size;i++) {
				dfs(x.child.get(i));
			}
		}
	}
	
	public static class Node{
		LinkedList<Node> child = new LinkedList<>();
		
		Node(){}
		
		public void addNode(Node node) {
			child.offer(node);
		}
		
		public void deleteNode(Node node) {
			int size = child.size();
			
			for(int i=0; i<size;i++) {
				if(child.get(i) == node) {
						child.remove(i);
						size = child.size();
						i--;
				}
			}
		}
		
	}

}
