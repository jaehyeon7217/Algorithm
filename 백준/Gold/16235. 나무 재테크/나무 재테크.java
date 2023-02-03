import java.io.*;
import java.util.*;

public class Main {

	public static int n, m, k;
	public static int[][] map;
	public static int[][] good;
	public static ArrayList<XY> tree = new ArrayList<>();
	public static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		good = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				good[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			tree.add(new XY(x,y,Integer.parseInt(st.nextToken())));
		}


		for (int K = 0; K < k; K++) {
			Collections.sort(tree);
			// 봄
			ArrayList<XY> tempList = new ArrayList<>();
			ArrayList<XY> die = new ArrayList<>();
			
			int size = tree.size();
			for(int i=0;i<size;i++) {
				XY temp = tree.get(i);

				if (map[temp.x][temp.y] < temp.bob) {
					die.add(new XY(temp.x, temp.y, temp.bob / 2));
					continue;
				} else {
					map[temp.x][temp.y] -= temp.bob;
					tempList.add(new XY(temp.x, temp.y, temp.bob + 1));
				}
			}
			
			tree = new ArrayList<>();
			tree.addAll(tempList);
			tempList = new ArrayList<>();
			

			// 여름
			size = die.size();
			for(int i=0;i<size;i++) {
				XY temp = die.get(i);
				map[temp.x][temp.y] += temp.bob;
			}

			// 가을
			size = tree.size();
			for(int k=0;k<size;k++){
				XY temp = tree.get(k);
				
				if (temp.bob % 5 != 0) continue;
				

				for (int i = 0; i < 8; i++) {
					int x = temp.x + dx[i];
					int y = temp.y + dy[i];

					if (x < 0 || x >= n || y < 0 || y >= n)
						continue;

					tree.add(new XY(x, y, 1));
				}
			}
			
			
			// 겨울
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] += good[i][j];
				}
			}
			

		}
		
		System.out.println(tree.size());

	}

	public static class XY implements Comparable<XY> {
		int x;
		int y;
		int bob;

		public XY(int x, int y, int bob) {
			super();
			this.x = x;
			this.y = y;
			this.bob = bob;
		}

		@Override
		public int compareTo(XY a) {
			return this.bob - a.bob;
		}
	}
	
}
