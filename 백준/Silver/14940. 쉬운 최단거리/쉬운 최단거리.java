import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<xy> q = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) map[i][j] = -1;
                else if (map[i][j] == 0) {
                    map[i][j] = 0;
                }
                else {
                    q.offer(new xy(i, j));
                    map[i][j] = 0;
                }

            }
        }

        while (!q.isEmpty()) {
            xy temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (map[x][y] != -1) continue;

                map[x][y] = map[temp.x][temp.y] + 1;
                q.offer(new xy(x, y));

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);


    }

    public static class xy {
        int x;
        int y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
