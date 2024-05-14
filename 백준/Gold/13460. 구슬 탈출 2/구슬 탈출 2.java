import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static char[][] board;
    public static Node R, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    R = new Node(i, j, 0);

                } else if (board[i][j] == 'B') {
                    B = new Node(i, j, 0);
                }
            }
        }

        int result = -1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Node> nowRList = new LinkedList<>();
        Queue<Node> nowBList = new LinkedList<>();
        nowRList.offer(R);
        nowBList.offer(B);

        bp:
        while (!nowRList.isEmpty()) {
            Node nowR = nowRList.poll();
            Node nowB = nowBList.poll();
            if (nowR.count >= 10) break;
            boolean goal = false;

            for (int i = 0; i < 4; i++) {
                boolean canChange = true; // 위치 바꿀지
                // 빨간공 부터 움직여 봅시다.
                boolean isExist = false; // 경로상 다른 공이 있나?
                int Rx = nowR.x;
                int Ry = nowR.y;
                while (true) {
                    Rx += dx[i];
                    Ry += dy[i];

                    if (board[Rx][Ry] == '#') {
                        Rx -= dx[i];
                        Ry -= dy[i];
                        if (isExist) { // 경로상 파란공이 있으면 한 칸 뒤로
                            Rx -= dx[i];
                            Ry -= dy[i];
                        }
                        break;
                    } else if (board[Rx][Ry] == 'O') {
                        if (!isExist) {
                            goal = true;
                        }
                        canChange = false;
                        break;
                    } else if (Rx == nowB.x && Ry == nowB.y) {
                        isExist = true;
                    }
                }

                // 파란공 움직이기
                int Bx = nowB.x;
                int By = nowB.y;
                // 경로상에 있었나?
                if (isExist) { // 있으면 끝
                    Bx = Rx + dx[i];
                    By = Ry + dy[i];

                } else { // 없으면 계산
                    while (true) {
                        Bx += dx[i];
                        By += dy[i];
                        if (board[Bx][By] == '#') {
                            Bx -= dx[i];
                            By -= dy[i];
                            if (isExist) {// 경로상 빨간공 있나?
                                Bx -= dx[i];
                                By -= dy[i];
                            }
                            break;
                        } else if (Bx == nowR.x && By == nowR.y) {
                            isExist = true;
                        } else if (board[Bx][By] == 'O') {
                            goal = false;
                            canChange = false;
                            break;
                        }
                    }
                }
                if (goal) {
                    result = nowR.count +1;
                    break bp;
                }

                if(Rx == nowR.x && Ry == nowR.y && Bx==nowB.x && By==nowB.y) continue;

                if (canChange) {
                    nowRList.offer(new Node(Rx, Ry, nowR.count + 1));
                    nowBList.offer(new Node(Bx, By, nowB.count + 1));
                }
            }
        }

        System.out.println(result);


    }

    public static class Node {
        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


}
