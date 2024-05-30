import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static PriorityQueue<Node> list;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        list = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            arr[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            list.offer(new Node(from, to, value));
        }

        int sum = 0;
        while(!list.isEmpty()){
            Node temp = list.poll();

            if(find(temp.to) == find(temp.from)) continue;
            union(temp.from, temp.to);

            if(isLast()){
                break;
            }
            sum+= temp.value;
        }

        System.out.println(sum);




    }
    public static boolean isLast(){
        boolean result = true;
        find(0);
        int temp = arr[0];
        for(int i=1;i<n; i++){
            find(i);
            if(arr[i] != temp){
                result = false;
                break;
            }
        }
        return result;
    }

    public static int find(int x){
        if(arr[x] == x){
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y){
            arr[y] = x;
        }else{
            arr[x] = y;
        }
    }



    public static class Node implements Comparable<Node>{
        int from;
        int to;
        int value;
        Node(int from, int to, int value){
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }


}
