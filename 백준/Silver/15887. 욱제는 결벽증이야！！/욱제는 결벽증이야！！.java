import java.io.*;
import java.util.*;


public class Main {

    public static int n, arr[], order[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        order = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            order[arr[i]] = i;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == i) continue;

            count++;
            sb.append(i + " " + order[i] + "\n");
            func(i, order[i]);

        }

        System.out.println(count + "\n" + sb.toString());

    }

    public static void func(int a, int b) {
        for (int i = 0; i < (b - a + 1) / 2; i++) {
            int temp = arr[a + i];
            arr[a + i] = arr[b - i];
            arr[b - i] = temp;

            order[arr[a + i]] = a + i;
            order[arr[b - i]] = b - i;
        }
    }
}
