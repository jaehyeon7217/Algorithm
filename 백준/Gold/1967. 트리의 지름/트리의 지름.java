import java.io.*;
import java.util.*;

public class Main {

    public static int n, result, maxNode;
    public static ArrayList<node>[] map;
    public static boolean[] check;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n];

        for(int i=0;i<n;i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            map[start].add(new node(end, value));
            map[end].add(new node(start, value));

        }
        maxNode = 0;
        result = 0;
        check = new boolean[n];
        check[0] = true;
        dfs(0,0);

        check = new boolean[n];
        check[maxNode]=true;
        dfs(maxNode, 0);

        System.out.println(result);

    }

    public static void dfs(int num, int sum){
        if(result < sum){
            result = sum;
            maxNode = num;
        }

        for(int i=0;i<map[num].size();i++){
            if(!check[map[num].get(i).x]){
                check[map[num].get(i).x] = true;
                dfs(map[num].get(i).x, sum + map[num].get(i).value);
            }
        }

    }


    public static class node{
        int x;
        int value;

        public node(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }
}
