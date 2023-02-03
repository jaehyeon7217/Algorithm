import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int size = 6;

		int[][] num = new int[size][2];
		boolean[] check = new boolean[size];

		int G = 0, S = 0;
		int indexG = 0, indexS = 0;

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());

			if (num[i][0] == 1 || num[i][0] == 2) {
				if (G < num[i][1]) {
					G = num[i][1];
					indexG = i;
				}
			}
			if (num[i][0] == 3 || num[i][0] == 4) {
				if (S < num[i][1]) {
					S = num[i][1];
					indexS = i;
				}
			}
		}

		// 가로 최대랑 세로 최대값에 인접한 값은 아니다.

		check[indexG] = true;
		check[indexS] = true;
		for (int i = -1; i < 2; i++) {
			int x = indexG + i;
			int y = indexS + i;

			if (x < 0)
				x = size-1;
			else if (y < 0)
				y = size-1;
			else if (x >= size)
				x = 0;
			else if (y >= size)
				y = 0;


			check[x] = true;
			check[y] = true;

		}

		int temp = 1;
		for (int i = 0; i < size; i++) {
			if (!check[i]) {
				temp *= num[i][1];
			}
		}


		temp = ((G * S) - temp) * t;

		System.out.println(temp);

		br.close();

	}
}