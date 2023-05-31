import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[] map;
    public static int[] tree;
    public static int[] maxTree;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int size = findSize();
        tree = new int[size];
        maxTree = new int[size];

        init(0, n - 1, 1);
        initMax(0,n-1,1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            sb.append(findValue(0,n-1,1,a,b) + " " +maxFindValue(0, n - 1, 1, a, b) + "\n");

        }

        System.out.println(sb);

    }

    public static int findSize() {
        int size = 2;
        while (size < n) {
            size *= 2;
        }
        return size * 2;
    }

    public static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = map[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));

    }

    public static int initMax(int start, int end, int node) {
        if (start == end) {
            return maxTree[node] = map[start];
        }

        int mid = (start + end) / 2;

        return maxTree[node] = Math.max(initMax(start, mid, node * 2), initMax(mid + 1, end, node * 2 + 1));

    }


    public static int findValue(int start, int end, int node, int x, int y) {
        if (y < start || end < x) return Integer.MAX_VALUE;
        if (x <= start && end <= y) return tree[node];

        int mid = (start + end) / 2;

        return Math.min(findValue(start, mid, node * 2, x, y), findValue(mid + 1, end, node * 2 + 1, x, y));

    }
    public static int maxFindValue(int start, int end, int node, int x, int y) {
        if (y < start || end < x) return Integer.MIN_VALUE;
        if (x <= start && end <= y) return maxTree[node];

        int mid = (start + end) / 2;

        return Math.max(maxFindValue(start, mid, node * 2, x, y), maxFindValue(mid + 1, end, node * 2 + 1, x, y));

    }

    public static void pr() {
        int size = findSize();
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

}
