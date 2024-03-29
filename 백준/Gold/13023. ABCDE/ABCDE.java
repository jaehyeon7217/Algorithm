import java.io.*;
import java.util.*;

public class Main {


    public static int n, m, result = 0;
    public static ArrayList<Integer>[] list;
    public static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        check = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }

        solve(0, 0);

        System.out.println(result);


    }

    public static boolean solve(int step, int start) {
        if (step == 5) {
            result = 1;
            return true;
        }

        if (step == 0) {
            for (int i = 0; i < n; i++) {

                check[i] = true;
                if (solve(step + 1, i))
                    return true;
                check[i] = false;

            }
        } else {
            for (int i : list[start]) {
                if (check[i]) continue;

                check[i] = true;
                if (solve(step + 1, i)) {
                    return true;
                }
                check[i] = false;

            }
        }
        return false;

    }


}