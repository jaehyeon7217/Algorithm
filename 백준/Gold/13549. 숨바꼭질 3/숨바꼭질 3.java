import java.io.*;
import java.util.*;

public class Main{

    public static int n, m, result;
    public static int[] check = new int[100001];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<node> q = new PriorityQueue<>();
        q.offer(new node(n,0));
        for(int i=0;i<100001;i++){
            check[i] = Integer.MAX_VALUE;
        }
        check[n] = 0;
        result = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            node temp = q.poll();
            int now = temp.now;
            int count = temp.count;

            if(now == m) {
                result = Math.min(result, count);
                break;
            }


            if(now*2 <=100000 && check[now*2]>count){
                q.offer(new node(now*2, count));
                check[now*2]= count;
            }

            if(now + 1<=100000 && check[now+1]>count+1){
                q.offer(new node(now+1, count+1));
                check[now+1]= count+1;
            }
            if(now - 1 >= 0 && check[now-1] > count+1){
                q.offer(new node(now-1, count+1));
                check[now-1] =  count+1;
            }

        }

        System.out.println(result);

    }

    public static class node implements Comparable<node>{
        int now;
        int count;

        @Override
        public int compareTo(node e){
            return this.count - e.count;
        }

        public node(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }
}