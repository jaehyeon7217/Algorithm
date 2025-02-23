import java.util.*;
import java.io.*;

public class Main {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 입력
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            LinkedList<node> person = new LinkedList<>(); // 현재 위치
            LinkedList<node> fire = new LinkedList<>(); // 불의 위치

            char[][] map = new char[h][w]; // 맵
            int[][] check = new int[h][w]; // 움직임 횟수 체크

            for (int i = 0; i < h; i++) {
                char[] info = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = info[j];

                    if (map[i][j] == '@') { // 현재 위치
                        person.offer(new node(i, j));
                    } else if (map[i][j] == '*') { // 불 위치 저장
                        fire.add(new node(i, j));
                    }
                }
            }

            // 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다. -> 불 먼저 이동

            int ans = 0;



            bp:
            while (!person.isEmpty()) {

                // 화재 먼저 이동
                LinkedList<node> fireNext = new LinkedList<>(); // 화재의 다음 위치를 담을 곳
                while (!fire.isEmpty()) {
                    node temp = fire.poll();

                    for (int i = 0; i < 4; i++) {
                        int x = temp.x + dx[i];
                        int y = temp.y + dy[i];


                        if (x < 0 || x >= h || y < 0 || y >= w) {
                            continue;
                        }
                        if (map[x][y] == '#' || map[x][y] == '*') { // 맵의 다음 위치가 벽이거나 이미 불난 곳이면 안감
                            continue;
                        }

                        map[x][y] = '*';
                        fireNext.add(new node(x, y)); // 다음 위치를 저장
                    }
                }

                // 불의 다음 위치를 다시 fire 에 저장
                fire.addAll(fireNext);

                LinkedList<node> personNext = new LinkedList<>();
                // 사람 이동
                while (!person.isEmpty()) {
                    node temp = person.poll();
                    for (int i = 0; i < 4; i++) {
                        int x = temp.x + dx[i];
                        int y = temp.y + dy[i];

                        if (x < 0 || x >= h || y < 0 || y >= w) { // 외곽 == 탈출
                            ans = check[temp.x][temp.y] + 1; 
                            break bp;
                        }
                        if (map[x][y] != '.') { // 맵의 다음 위치가 빈 곳이 아니면 못감
                            continue;
                        }

                        personNext.add(new node(x,y));
                        map[x][y] = '@';
                        check[x][y] = check[temp.x][temp.y]+1; // 시간 카운트

                    }
                }

                person.addAll(personNext); // 다음 사람을 저장
            }

            sb.append(ans == 0 ? "IMPOSSIBLE\n" : ans + "\n");

        }

        System.out.println(sb);


    }

    public static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
