import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static final int inf = 1234567890;
    public static ArrayList<bus> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            list.add(new bus(s, e, t));

        }

        if(n==1){
            System.exit(0);
        }
        long[] d = new long[n];
        Arrays.fill(d, inf);
        d[0] = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                bus temp = list.get(j);

                if (d[temp.s] != inf && (d[temp.e] > d[temp.s] + temp.t)) {
                    if (i == n - 1) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    d[temp.e] = d[temp.s] + temp.t;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            sb.append((d[i] == inf ? "-1" : d[i]) + "\n");
        }
        System.out.println(sb.toString());


    }


    public static class bus {
        int s;
        int e;
        int t;

        bus(int s, int e, int t) {
            this.s = s;
            this.e = e;
            this.t = t;
        }

    }

}