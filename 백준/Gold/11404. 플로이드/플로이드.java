import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] dis;
    public static ArrayList<ArrayList<XY>> bus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        bus = new ArrayList<>();

        for(int i=0;i<n;i++){
            bus.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            bus.get(start).add(new XY(end, cost));
        }

        dis = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dis[i][j] = 0;
                else dis[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<n;i++){
            func(i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append((dis[i][j] == Integer.MAX_VALUE ? "0" : dis[i][j]) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    public static void func(int target){

        PriorityQueue<XY> que = new PriorityQueue<>();

        que.add(new XY(target, 0));

        while(!que.isEmpty()){
            XY temp = que.poll();

            for(int i=0;i<bus.get(temp.x).size();i++){
                XY cur = bus.get(temp.x).get(i);

                if(dis[target][cur.x] > temp.cost + cur.cost){
                    dis[target][cur.x] = temp.cost + cur.cost;
                    que.add(new XY(cur.x, temp.cost + cur.cost));
                }

            }

        }

    }

    public static class XY implements Comparable<XY>{
        int x;
        int cost;

        public XY(int x, int cost){
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(XY o){
            return this.cost-o.cost;
        }
    }
}