import java.io.*;
import java.util.*;

public class Main {

    public static int[][] sudoku = new int[9][9];
    public static ArrayList<node> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
                    list.add(new node(i, j));
                }
            }
        }

        func(0);


    }

    // 빈자리 찾기
    public static boolean func(int step) {
        if (step == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }

            return true;
        }

        node temp = list.get(step);

        boolean[] num = check(temp.x, temp.y);

        for (int i = 1; i < 10; i++) {
            if (num[i]) continue;

            sudoku[temp.x][temp.y] = i;
            if (func(step + 1)) return true;
            sudoku[temp.x][temp.y] = 0;
        }

        return false;

    }


    // 가능한 수 체크
    public static boolean[] check(int x, int y) {
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        boolean[] arr = new boolean[10];

        // 가로체크
        for (int i = 0; i < 9; i++) {
            arr[sudoku[i][y]] = true;
        }

        // 세로체크
        for (int i = 0; i < 9; i++) {
            arr[sudoku[x][i]] = true;
        }

        // 사각형 체크
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                arr[sudoku[i][j]] = true;
            }
        }

        return arr;

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