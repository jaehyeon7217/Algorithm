import java.io.*;
import java.util.*;

import javax.sound.midi.Soundbank;

public class Main {

	public static int n, result = 0;
	public static int[] map;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		
		map = new int[n];
		dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}

		if(n == 1) {
			System.out.println(map[0]);
			System.exit(0);
		}
		
		dp[0][1] = map[0];
		dfs(0, 1, map[0]);
		dp[1][1] = map[1];
		dfs(1, 1, map[1]);

		System.out.println(result);

		br.close();

	}

	public static void dfs(int x, int st, int count) {
		if (x == n - 1) {
			result = Math.max(result, count);
			return;
		}

		if (x + 1 == n - 1) {
			if (st == 2)
				return;
			else if (dp[x + 1][st + 1] < count + map[x + 1]) {
				dp[x + 1][st + 1] = count + map[x + 1];
				dfs(x + 1, st + 1, count + map[x + 1]);
			}
		} else {
			if (st == 2) {
				if (dp[x + 2][1] < count + map[x + 2]) {
					dp[x + 2][1] = count + map[x + 2];
					dfs(x + 2, 1, count + map[x + 2]);

				}
			}

			else {
				if (dp[x + 1][st + 1] < count + map[x + 1]) {
					dp[x + 1][st + 1] = count + map[x + 1];
					dfs(x + 1, st + 1, count + map[x + 1]);
				}
				if (dp[x + 2][1] < count + map[x + 2]) {
					dp[x + 2][1] = count + map[x + 2];
					dfs(x + 2, 1, count + map[x + 2]);
				}
			}
		}

	}

}
