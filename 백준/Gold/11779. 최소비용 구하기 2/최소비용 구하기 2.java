import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, start, end;
    public static ArrayList<ArrayList<node>> bus;
    public static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        bus = new ArrayList<>();
        for(int i=0;i<n;i++){
            bus.add(new ArrayList<>());
        }
        check = new int[n];
        Arrays.fill(check,1234567890);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int f = Integer.parseInt(st.nextToken());

            bus.get(s).add(new node(e,f));

        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken())-1;
        end = Integer.parseInt(st.nextToken())-1;

        check[start] = 0;

        PriorityQueue<node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        sb.append((start+1) + " ");
        pq.add(new node(start,0,1,sb));

        while(!pq.isEmpty()){
            node temp = pq.poll();

            if(temp.x == end){
                StringBuilder sbTemp = new StringBuilder();
                sbTemp.append( temp.fee + "\n");
                sbTemp.append(temp.count + "\n");
                sbTemp.append(temp.sb.toString() );
                System.out.println(sbTemp);
                return;
            }

            int size = bus.get(temp.x).size();

            for(int i=0;i<size;i++){
                node next = bus.get(temp.x).get(i);
                if(check[next.x] <= temp.fee + next.fee) continue;

                check[next.x] = temp.fee + next.fee;
                StringBuilder nextSB = new StringBuilder();
                nextSB.append(temp.sb.toString() + (next.x+1)  + " ");
                pq.add(new node(next.x, temp.fee+next.fee, temp.count+1, nextSB));

            }

        }

    }

    public static class node implements Comparable<node>{
        int x;
        int fee;
        int count;

        StringBuilder sb;

        node(int x, int fee){
            this(x,fee,0,null);
        }

        node(int x, int fee, int count, StringBuilder sb){
            this.x=x;
            this.fee = fee;
            this.count = count;
            this.sb = sb;
        }

        @Override
        public int compareTo(node o){
            return this.fee-o.fee;
        }
    }
}