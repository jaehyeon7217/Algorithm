import java.io.*;
import java.util.*;

public class Main {
    public static char[][] star;
    public static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        star = new char[n][(n - 1) * 2 + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(star[i], ' ');
        }

        solve(n, 0,0);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - 1) * 2 + 1; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void solve(int step, int x, int y) {
        if (step == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 2 - i; j < 5; j += 3 - i) {
                    star[x + i][y + j] = '*';
                }
            }
            return;
        }

        int next = step>>1;

        solve(next, x, y+(step/2));
        solve(next, x+(step/2), y);
        solve(next, x+(step/2), y+step);

    }

}