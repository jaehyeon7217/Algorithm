import java.io.*;
import java.util.*;

public class Main {

    public static int n, max = Integer.MIN_VALUE;
    public static int[][] board;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);

        System.out.println(max);

    }

    public static void solve(int set) {
        if (set == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }
        int[][] first = init(); // 백트레킹해야하니 미리 저장

        // up down right left
        up();
        solve(set+1);
        back(first);

        down();
        solve(set+1);
        back(first);

        right();
        solve(set+1);
        back(first);

        left();
        solve(set+1);
        back(first);



    }

    public static int[][] init(){
        int[][] first = new int[n][n]; // 백트레킹해야하니 미리 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                first[i][j] = board[i][j];
            }
        }
        return first;
    }
    public static void back(int[][] first){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = first[i][j];
            }
        }
    }

    public static void up() {
        boolean[][] check = new boolean[n][n]; // 합쳐진적 있는지 체크
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] != 0) { // 현재 칸이 빈칸이 아님
                    int flag = i - 1; // 위를 조사
                    while (flag >= 0) { // 계속 위로 감
                        if (board[flag][j] == 0) { // 위에 칸이 빈칸임
                            board[flag][j] = board[flag + 1][j]; // 위로 한 칸 옮기고 다시 진행
                            board[flag + 1][j] = 0;
                            flag--;
                        } else { // 빈칸아님
                            if (check[flag][j]) break; // 합쳐진적 있으면 끝
                            if (board[flag][j] == board[flag + 1][j]) { // 위가 빈칸 아니고 현재 칸이랑 같은 값이면
                                board[flag][j] += board[flag + 1][j]; // 합침
                                board[flag + 1][j] = 0;
                                check[flag][j] = true;
                            }
                            break;
                        }

                    }
                }
            }
        }
    }

    public static void down() {
        boolean[][] check = new boolean[n][n]; // 합쳐진적 있는지 체크
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] != 0) { // 현재 칸이 빈칸이 아님
                    int flag = i + 1; // 아래를 조사
                    while (flag < n) { // 계속 아래로 감
                        if (board[flag][j] == 0) { // 아래가 칸이 빈칸임
                            board[flag][j] = board[flag - 1][j]; // 위로 한 칸 옮기고 다시 진행
                            board[flag - 1][j] = 0;
                            flag++;
                        } else { // 빈칸아님
                            if (check[flag][j]) break; // 합쳐진적 있으면 끝
                            if (board[flag][j] == board[flag - 1][j]) { // 아래 빈칸 아니고 현재 칸이랑 같은 값이면
                                board[flag][j] += board[flag - 1][j]; // 합침
                                board[flag - 1][j] = 0;
                                check[flag][j] = true;
                            }
                            break;
                        }

                    }
                }
            }
        }
    }

    public static void left() {
        boolean[][] check = new boolean[n][n]; // 합쳐진적 있는지 체크
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n; i++) {

                if (board[i][j] != 0) { // 현재 칸이 빈칸이 아님
                    int flag = j - 1; // 왼쪽를 조사
                    while (flag >= 0) { // 계속 왼쪽으로 감
                        if (board[i][flag] == 0) { // 왼쪽에 칸이 빈칸임
                            board[i][flag] = board[i][flag+1]; // 왼쪽으로 한 칸 옮기고 다시 진행
                            board[i][flag+1] = 0;
                            flag--;
                        } else { // 빈칸아님
                            if (check[i][flag]) break; // 합쳐진적 있으면 끝
                            if (board[i][flag] == board[i][flag+1]) { // 왼쪽칸이 빈칸 아니고 현재 칸이랑 같은 값이면
                                board[i][flag] += board[i][flag+1]; // 합침
                                board[i][flag+1] = 0;
                                check[i][flag] = true;
                            }
                            break;
                        }

                    }
                }
            }
        }
    }

    public static void right() {
        boolean[][] check = new boolean[n][n]; // 합쳐진적 있는지 체크
        for (int j = n-2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {

                if (board[i][j] != 0) { // 현재 칸이 빈칸이 아님
                    int flag = j + 1; // 오른쪽을 조사
                    while (flag < n) { // 계속 오른쪽으로 감
                        if (board[i][flag] == 0) { // 오른쪽 칸이 빈칸임
                            board[i][flag] = board[i][flag-1]; // 오른쪽으로 한 칸 옮기고 다시 진행
                            board[i][flag-1] = 0;
                            flag++;
                        } else { // 빈칸아님
                            if (check[i][flag]) break; // 합쳐진적 있으면 끝
                            if (board[i][flag] == board[i][flag-1]) { // 오른쪽 빈칸 아니고 현재 칸이랑 같은 값이면
                                board[i][flag] += board[i][flag-1]; // 합침
                                board[i][flag-1] = 0;
                                check[i][flag] = true;
                            }
                            break;
                        }

                    }
                }
            }
        }
    }

}