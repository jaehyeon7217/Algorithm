import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int T = nextInt();

        while (T-- > 0) {
            int v = nextInt();
            int e = nextInt();

            ArrayList<Integer>[] arr = new ArrayList[v];

            for (int i = 0; i < v; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                int S = nextInt() - 1;
                int E = nextInt() - 1;

                arr[S].add(E);
                arr[E].add(S);
            }

            int[] check = new int[v];
            boolean[] visit = new boolean[v];

            boolean flag = false;
            bp : for(int k=0;k<v;k++) {

                if(check[k] != 0) continue;

                Queue<Integer> q = new LinkedList<>();
                q.offer(k);
                check[k] = 1;


                while (!q.isEmpty()) {
                    int now = q.poll();
                    visit[now] = true;

                    for (int i = 0; i < arr[now].size(); i++) {
                        if (check[arr[now].get(i)] == 0) {
                            check[arr[now].get(i)] = check[now] == 1 ? 2 : 1;
                        } else {
                            if (check[arr[now].get(i)] == check[now]) {
                                q.clear();
                                flag = true;
                                break bp;
                            }
                        }

                        if (!visit[arr[now].get(i)]) {
                            q.offer(arr[now].get(i));
                        }

                    }

                }
            }

            if(flag){
                sb.append("NO\n");
            }else{
                sb.append("YES\n");
            }

        }

        System.out.println(sb);



    }

    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static String next() throws Exception {
        st.nextToken();
        return st.sval;
    }

}
