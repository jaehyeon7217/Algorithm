import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, w;
    public static final int inf = 1234567890;
    public static ArrayList<node> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
//            System.out.println(T+"-----------------------------------------");
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken());

                list.add(new node(s, e, v));
                list.add(new node(e, s, v));

            }
            boolean f = true;
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) * (-1);

                if (s == e) {
                    f = false;
                }

                list.add(new node(s, e, v));
            }

            if (!f) {
                sb.append("YES\n");
                continue;
            }

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!solve(i)) {
                    flag = false;
                    break;
                }
                ;
            }
            sb.append(flag ? "NO" : "YES").append("\n");

        }

        System.out.println(sb.toString());

    }

    public static boolean solve(int start) {
//        System.out.println("start = " + start);
        int[] d = new int[n];

        Arrays.fill(d, inf);
        d[start] = 0;

        for (int i = 0; i < n; i++) {
            boolean check = false;
            int size = list.size();
            for (int j = 0; j < size; j++) {
                node temp = list.get(j);

//                System.out.println("d[temp.end] : " + d[temp.end] + ", d[temp.start] : " + d[temp.start] + ", temp.cost : " + temp.cost + ", sum : " + (d[temp.start] + temp.cost));
                if (d[temp.start] != inf && (d[temp.end] > d[temp.start] + temp.cost)) {
                    d[temp.end] = d[temp.start] + temp.cost;
                    check = true;
//                    System.out.println(i);
                    if (i == n - 1) {
                        return false;
                    }
                }

//                for(int z=0;z<n;z++){
//                    System.out.print(d[z] + " ");
//                }
//                System.out.println();

            }

            if (!check) break;

        }

        return true;

    }

    public static class node {
        int start;
        int end;
        int cost;

        node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }


}