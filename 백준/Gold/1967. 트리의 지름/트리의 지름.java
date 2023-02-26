import java.io.*;
import java.util.*;

public class Main {

    public static int n, result;
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

        int maxNode = bfs(0);

        bfs(maxNode);

        System.out.println(result);

    }

    public static int bfs(int x){
        int maxNode = 0;
        result = 0;
        Queue<node> q = new LinkedList<>();
        check = new boolean[n];
        q.add(new node(x,0));
        check[x] = true;

        while(!q.isEmpty()){
            node temp = q.poll();

            if(result < temp.value){
                maxNode = temp.x;
                result = temp.value;
            }

            for(int i=0;i<map[temp.x].size();i++){
                int dx = map[temp.x].get(i).x;
                int dValue = map[temp.x].get(i).value;
                if(!check[dx]){
                    check[dx] = true;
                    q.offer(new node(dx, dValue + temp.value));
                }
            }
        }

        return maxNode;
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
