import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine()) - 1;

		ArrayList<Node>[] node = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			node[i] = new ArrayList<>();
		}

		int[] D = new int[n];
		boolean[] check = new boolean[n];

		Arrays.fill(D, Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			node[from].add(new Node(to, weight));
		}

		D[start] = 0;

		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> o1.weight - o2.weight);
		q.offer(new Node(start, 0));

		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (check[temp.x])
				continue;

			check[temp.x] = true;

			for (Node t : node[temp.x]) {
				if (!check[t.x] && D[t.x] > D[temp.x] + t.weight) {
					D[t.x] = D[temp.x] + t.weight;
					q.offer(new Node(t.x, D[t.x]));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(D[i] == Integer.MAX_VALUE ? "INF\n" : D[i] + "\n");
		}

		System.out.println(sb);
		br.close();
	}

	public static class Node {
		int x;
		int weight;

		public Node(int x, int weight) {
			super();
			this.x = x;
			this.weight = weight;
		}

	}

}
