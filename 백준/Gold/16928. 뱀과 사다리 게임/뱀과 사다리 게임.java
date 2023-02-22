import java.io.*;
import java.util.*;

public class Main{

    public static int n, m;

    public static int[] map = new int[101];
    public static int[] check = new int[101];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n+m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start]= end;
        }

        PriorityQueue<node> q = new PriorityQueue<>();
        q.offer(new node(1,0));

        for(int i=0;i<101;i++){
            check[i] = Integer.MAX_VALUE;
        }

        int count=0;

        while(!q.isEmpty()){
            node temp = q.poll();

            if(temp.now == 100){
                count = temp.count;
                break;
            }
            for(int i=1;i<7;i++){
                if(temp.now + i >100) continue;
                if(map[temp.now+i] != 0){
                    if(map[temp.now] < map[temp.now + i] && check[map[temp.now+i]] > temp.count+1 ) {
                        check[temp.now+i] = temp.count+1;
                        q.offer(new node(map[temp.now + i], temp.count + 1));
                    }
                }else{
                    if(check[temp.now+i] > temp.count+1) {
                        check[temp.now+i] = temp.count+1;
                        q.offer(new node(temp.now + i, temp.count + 1));
                    }
                }

            }

        }

        System.out.println(count);


    }

    public static class node implements Comparable<node>{
        int now;
        int count;
        public node(int now, int count) {
            this.now = now;
            this.count = count;
        }

        @Override
        public int compareTo(node e){
            return this.count == e.count ? e.now - this.now : this.count-e.count;
        }
    }
}
