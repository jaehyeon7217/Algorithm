import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int result = 0;
		boolean[] visit = new boolean[1000001];

		Queue<data> q = new LinkedList<>();

		q.offer(new data(n, 0));
		visit[n] = true;

		while (!q.isEmpty()) {
			data temp = q.poll();

			if (temp.n == 1) {
				result = temp.count;
				q.clear();
				break;
			}

			if (temp.n % 3 == 0 && !visit[temp.n / 3]) {
				q.offer(new data(temp.n / 3, temp.count + 1));
				visit[temp.n / 3] = true;
			} 
			if (temp.n % 2 == 0 && !visit[temp.n / 2]) {
				visit[temp.n / 2] = true;
				q.offer(new data(temp.n / 2, temp.count + 1));
			}

			if (!visit[temp.n - 1]) {
				q.offer(new data(temp.n - 1, temp.count + 1));
				visit[temp.n - 1] = true;
			}

		}

		System.out.println(result);

	}

	public static class data {
		int n;
		int count;

		public data(int n, int count) {
			super();
			this.n = n;
			this.count = count;
		}

		@Override
		public String toString() {
			return "data [n=" + n + ", count=" + count + "]";
		}
	}
}
