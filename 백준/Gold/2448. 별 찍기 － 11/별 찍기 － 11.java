import java.io.*;
import java.util.*;

public class Main {
    public static char[][] star;
    public static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int temp = n / 3;
        k = 0;
        while (temp != 1) {
            temp = temp >> 1;
            k++;
        }

        star = new char[n][(n - 1) * 2 + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(star[i], ' ');
        }

        solve(k, 0,0);


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
        if (step == 0) {
            paint(x, y);
            return;
        }

        int temp = 3* (int)(Math.pow(2.0,step));

        solve(step-1, x, y+(temp/2));
        solve(step-1, x+(temp/2), y);
        solve(step-1, x+(temp/2), y+temp);

    }

    public static void paint(int startX, int startY) {
        for (int i = 0; i < 3; i++) {
            for (int j = 2 - i; j < 5; j += 3 - i) {
                star[startX + i][startY + j] = '*';
            }
        }
    }

}