import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[] check;
    public static Node[] node;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[n];
        node = new Node[n];

        for(int i=0;i<n;i++){
            node[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int last = Integer.parseInt(st.nextToken()) - 1;

            node[first].offer(node[last]);
            check[last]++;

        }

        PriorityQueue<Integer> q= new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(check[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int temp = q.poll();

            sb.append( (node[temp].x+1) + " " );

            for(Node x : node[temp].next){
                check[x.x]--;

                if(check[x.x] == 0){
                    q.offer(x.x);
                }

            }

        }


        System.out.println(sb);


    }

    public static class Node implements Comparable<Node> {
        int x;
        PriorityQueue<Node> next;

        Node(int x) {
            this.x = x;
            next = new PriorityQueue<>();
        }

        public void offer(Node x) {
            next.offer(x);
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x;
        }

    }


}
