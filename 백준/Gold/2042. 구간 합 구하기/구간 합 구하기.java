import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[][] map = new long[n][3];

		map[0][0] = map[0][1] = Long.parseLong(br.readLine());
		for (int i = 1; i < n; i++) {
			map[i][0] = Long.parseLong(br.readLine());
			map[i][1] = map[i - 1][1] + map[i][0];
		}

		int[] member = new int[m];
		boolean[] use = new boolean[n];
		int top = 0;

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int check = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken()) - 1;
			long index2 = Long.parseLong(st.nextToken());

			if (check == 1) {
				if(!use[index]) {
					member[top++] = index;
					use[index] = true;
					
				}
				map[index][2] = index2 - map[index][0];
			}

			else {
				long sum = 0L;
				if (index == 0)
					sum = map[(int) index2 - 1][1];
				else
					sum = map[(int) index2 - 1][1] - map[index - 1][1];
				
				for (int j = 0; j < top; j++) {
					if (member[j] >= index && member[j] <= (index2 - 1)) {
						sum += map[member[j]][2];
					}
				}
				sb.append(sum + "\n");
			}
		}
		System.out.println(sb);

		br.close();

	}

}
