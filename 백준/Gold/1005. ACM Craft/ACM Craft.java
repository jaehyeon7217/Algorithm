import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] endTime;
    public static Node[] node;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int T=0;T<t;T++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            node = new Node[n];
            endTime = new int[n];
            Arrays.fill(endTime,-1);

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                node[i] = new Node(i,Integer.parseInt(st.nextToken()));
            }

            for(int i=0;i<k;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                node[to].add(node[from]);
            }

            int end = Integer.parseInt(br.readLine())-1;

            sb.append(find(end) + "\n");

        }

        System.out.println(sb);


    }

    public static int find(int no){
        if(endTime[no] == -1){
            endTime[no] = 0;
            if(!node[no].require.isEmpty()){
                int max = 0;
                for(int i=0;i<node[no].require.size();i++){
                    max = Math.max(find(node[no].require.get(i).no),max);
                }
                endTime[no] = max;
            }
            endTime[no] += node[no].time;
        }

        return endTime[no];


    }

    public static class Node{
        int no;
        int time;
        LinkedList<Node> require;

        public void add(Node n){
            this.require.add(n);
        }

        Node(int no, int time){
            this.time = time;
            this.no = no;
            require = new LinkedList<>();
        }
    }

}
