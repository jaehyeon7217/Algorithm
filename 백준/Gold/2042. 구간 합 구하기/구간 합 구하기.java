import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, k;
    public static long[] map;
    public static long[] tree;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new long[n];
        tree = new long[findSize()];

        for (int i = 0; i < n; i++) {
            map[i] = Long.parseLong(br.readLine());
        }

        makeTree(0, n - 1, 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            if (flag == 1) {
                long diff = value - map[node - 1];
                map[node - 1] = value;
                update(0, n - 1, node - 1, 1, diff);
            } else {
                sb.append(findTree(0, n - 1, 1, node - 1, value - 1) + "\n");
            }

        }

        System.out.println(sb.toString());

    }

    public static long findTree(int start, int end, int node, int left, long right) {
        if (end < left || start > right) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        long result = findTree(start, mid, node * 2, left, right) + findTree(mid + 1, end, node * 2 + 1, left, right);

        return result;

    }

    public static void update(int start, int end, int index, int node, long diff) {
        if (start > index || end < index) return;

        int mid = (start + end) / 2;

        tree[node] += diff;

        if (start == end) return;

        update(start, mid, index, node * 2, diff);
        update(mid + 1, end, index, node * 2 + 1, diff);

    }

    public static long makeTree(int start, int end, int node) {
        if (start == end) {
            return tree[node] = map[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = makeTree(start, mid, node * 2) + makeTree(mid + 1, end, node * 2 + 1);

    }

    public static int findSize() {
        int size = 2;
        while (size < n) {
            size *= 2;
        }
        return size * 2;
    }


}
