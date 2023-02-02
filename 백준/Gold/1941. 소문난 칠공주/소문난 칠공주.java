import java.io.*;
import java.util.*;

public class Main {

	public static int n = 5, result = 0;
	public static char[][] map = new char[n][n];
	public static boolean[][] check = new boolean[n][n];
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 0);

		System.out.println(result);

	}

	public static void dfs(int num, int startX, int startY) {
		if (num == 7) {
			LinkedList<XY> back = new LinkedList<>();
			int S = 0;
			int count=0;
			// 연결 확인
			Queue<XY> q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j]) {
						count++;
						if (map[i][j] == 'S') {
							S++;
						}

						if (q.isEmpty()) {
							q.offer(new XY(i, j));
							check[i][j] = false;
							back.add(new XY(i,j));
						}
					}
				}
			}
			if (S < 4) {
				
				while(!back.isEmpty()) {
					XY temp = back.poll();
					check[temp.x][temp.y] = true;
				}
				
				return;
			}

			while (!q.isEmpty()) {
				XY temp = q.poll();

				for (int i = 0; i < 4; i++) {
					int x = temp.x + dx[i];
					int y = temp.y + dy[i];

					if (x < 0 || x >= n || y < 0 || y >= n)
						continue;
					if (!check[x][y])
						continue;
					check[x][y] = false;
					back.add(new XY(x,y));
					q.offer(new XY(x, y));
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j]) {
						while(!back.isEmpty()) {
							XY temp = back.poll();
							check[temp.x][temp.y] = true;
						}						
						return;
					}
				}
			}

			result++;
			while(!back.isEmpty()) {
				XY temp = back.poll();
				check[temp.x][temp.y] = true;
			}
			return;
		}

		// 점 7개 추출

		for (int i = startX; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == startX && j < startY)
					continue;
				
				check[i][j] = true;
				
				if(j == n-1) dfs(num + 1, i+1, 0);
				else dfs(num+1, i, j+1);
				
				check[i][j] = false;

			}
		}

	}

	public static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
