import java.io.*;
import java.util.*;

public class Main{

    public static int n, result=0, maxNode=0;
    public static ArrayList<node>[] map;
    public static boolean[] check;
    public static int[] line;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new ArrayList[n];
        line = new int[n];
        check = new boolean[n];

        for(int i=0;i<n;i++)
            line[i]=i;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            map[start] = new ArrayList<>();
            while(true) {
                int end = Integer.parseInt(st.nextToken()) - 1;
                if (end == -2)
                    break;

                int value = Integer.parseInt(st.nextToken());
                map[start].add(new node(end,value));
            }

        }

        dfs(0,0);

        check = new boolean[n];
        dfs(maxNode,0);

        System.out.println(result);

    }

    public static void dfs(int x, int value){
        if(result<value){
            result = value;
            maxNode = x;
        }
        check[x] = true;

        for(int i=0;i<map[x].size();i++){
            if(!check[map[x].get(i).x]){
                dfs(map[x].get(i).x,value+map[x].get(i).value);
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