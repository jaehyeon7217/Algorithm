import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, count =0;
    public static int[] parent;
    public static int[] origin;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        origin = new int[n+1];
        List<Integer> list = new ArrayList<>();
        origin[1] = 1;

        for(int i=1;i<=n-1;i++){
            origin[i+1] = Integer.parseInt(br.readLine());
        }
        String[] input = new String[n-1+m];
        String[] answer = new String[m];
        int answerFlag =0;

        for(int i=0;i<n-1+m;i++){
            input[i]=br.readLine();
        }

        for(int i=n-2+m;i>=0;i--){
            st = new StringTokenizer(input[i]);

            int flag = Integer.parseInt(st.nextToken());
            if(flag == 0){
                int temp = Integer.parseInt(st.nextToken());
                union(temp, origin[temp]);

            }else{
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                answer[answerFlag++] = check(a,b) ? "YES\n" : "NO\n";

            }

        }
        for(int i=m-1;i>=0;i--){
            sb.append(answer[i]);
        }


        System.out.println(sb.toString());

    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static boolean check(int x, int y){
        return find(x) == find(y) ? true: false;
    }


}
