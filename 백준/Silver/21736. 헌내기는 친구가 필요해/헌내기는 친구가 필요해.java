import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<xy> q = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        boolean[][] check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'I'){
                    q.offer(new xy(i,j));
                    check[i][j] = true;
                }

            }
        }

        int count=0;

        while (!q.isEmpty()) {
            xy temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];

                if (x < 0 || x >= n || y < 0 || y>=m) continue;
                if(check[x][y]) continue;
                if(map[x][y] == 'X') continue;
                if(map[x][y] == 'P'){
                    count ++;
                }
                q.offer(new xy(x, y));
                check[x][y] = true;

            }
        }

        System.out.println(count == 0 ? "TT" : count);


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
