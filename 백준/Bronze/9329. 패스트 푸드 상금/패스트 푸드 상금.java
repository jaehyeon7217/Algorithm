import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] sticker = new int[m];

            int[][] needs = new int[n][];
            int[] reward = new int[n];
            int k = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                k = Integer.parseInt(st.nextToken());
                needs[i] = new int[k+1];
                needs[i][0] = k;
                for (int j = 1; j <= k; j++) {
                    needs[i][j] = Integer.parseInt(st.nextToken())-1;
                }

                reward[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < m; i++) {
                sticker[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for (int i = 0; i < n; i++) {


                bp:
                while (true) {
                    for (int j = 0; j < needs[i][0]; j++) {
                        sticker[needs[i][j+1]]--;
                        if (sticker[needs[i][j+1]] < 0) {
                            break bp;
                        }
                    }
                    answer += reward[i];
                }

            }
            sb.append(answer+"\n");

        }

        System.out.println(sb);
    }
}
