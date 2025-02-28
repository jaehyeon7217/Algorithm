import java.util.*;
import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);
    public static int n, m, k, map[][], sticker[][], count = 0;


    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        k = nextInt();

        map = new int[n][m];


        for (int t = 0; t < k; t++) {
            int r = nextInt();
            int c = nextInt();

            sticker = new int[r][c];

            for (int j = 0; j < r; j++) {
                for (int l = 0; l < c; l++) {
                    sticker[j][l] = nextInt();
                }
            }

            bp: // 4 * 30 * 30 * 10 * 10 == 360,000 ?
            for (int T = 0; T < 4; T++) { // 최대 4번 회전
                // 붙일 수 있는지 체크
                for (int i = 0; i <= n - r; i++) {
                    for (int j = 0; j <= m - c; j++) {
                        if (check(i, j)) {
                            for (int a = 0; a < r; a++) {
                                for (int b = 0; b < c; b++) {
                                    if(sticker[a][b] == 1) {
                                        map[i + a][j + b] = 1;
                                        count++;
                                    }
                                }
                            }
                            break bp; // 붙였으면 종료
                        }
                    }
                }

                // 못 붙였으면 90도 회전
                rotate(r,c);
                int temp = r;
                r = c;
                c = temp;
            }

        }


        System.out.println(count);

    }

    public static boolean check(int a, int b) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (sticker[i][j] == 1 && map[i + a][j + b] == 1) return false;
            }
        }
        return true;
    }

    public static void pr() {
        System.out.println("pr");
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                System.out.print(sticker[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void prMap(){
        System.out.println("prMap");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rotate(int b, int c) {
        int[][] temp = new int[c][b];

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < c; j++) {
                temp[j][b - 1 - i] = sticker[i][j];
            }
        }

        sticker = new int[c][b];
        sticker = temp;
    }


    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

}
