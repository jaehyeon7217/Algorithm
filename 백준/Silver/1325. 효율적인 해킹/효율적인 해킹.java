import java.util.*;
import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);
    public static StringBuilder sb = new StringBuilder();

    public static int n, m, count[];
    public static ArrayList<Integer>[] list;
    public static boolean[] visit;

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();

        list = new ArrayList[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;

            list[a].add(b);
        }

        for(int i=0;i<n;i++) {
            visit = new boolean[n];
            dfs(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int max = -1;

        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                ans.clear();
                ans.add(i);
            } else if (count[i] == max) {
                ans.add(i);
            }
        }
        Collections.sort(ans);

        for (int i : ans) {
            sb.append((i + 1) + " ");
        }

        System.out.println(sb);

    }

    public static void dfs(int num) {
        visit[num] = true;

        for(int i : list[num]){
            if(visit[i]) continue;
            count[i]++;
            dfs(i);
        }

    }


    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}
