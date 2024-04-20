import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<node>> list;
    static int[] visit;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        visit = new int[n];
        Arrays.fill(visit, 1234567890);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int fee = Integer.parseInt(st.nextToken());

            list.get(from).add(new node(to, fee));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        PriorityQueue<node> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        pq.add(new node(start,0,0,sb));
        visit[start] = 0;

        while(!pq.isEmpty()){
            node temp = pq.poll();

            if(temp.to == end){
                System.out.println(temp.fee);
                System.out.println(temp.count+1);
                System.out.println(temp.sb.toString() + (temp.to+1));
                return;
            }

            for(int i=0;i<list.get(temp.to).size(); i++){
                node bus = list.get(temp.to).get(i);

                if(visit[bus.to] <= temp.fee+bus.fee) continue;
                visit[bus.to] = temp.fee + bus.fee;

                pq.add(new node(bus.to, bus.fee+temp.fee, temp.count+1, new StringBuilder().append(temp.sb.toString()).append(temp.to+1).append(" ")));

            }

        }





    }

    static class node implements Comparable<node>{
        int to;
        int fee;
        StringBuilder sb;
        int count;

        node(int to, int fee){
            this.to = to;
            this. fee = fee;
        }
        node(int to, int fee,int count, StringBuilder sb){
            this.to = to;
            this. fee = fee;
            this. count = count;
            this.sb = sb;
        }

        @Override
        public int compareTo(node o){
            return this.fee-o.fee;
        }
    }

}