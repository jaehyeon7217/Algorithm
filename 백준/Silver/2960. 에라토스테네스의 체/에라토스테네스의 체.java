import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int result = 0;

		int count = 0;

		boolean[] check = new boolean[n + 1];
		loop: for (int i = 2; i <= n; i++) {
			if(check[i]) continue;
			result = i;
			while (true) {
				if (!check[result]) {
					check[result] = true;
					++count;
					if (count == k) {
						break loop;
					}
				}
				result += i;
				if (result > n) {
					result -= i;
					break;
				}
			}
		}

		System.out.println(result);

		br.close();

	}

}
