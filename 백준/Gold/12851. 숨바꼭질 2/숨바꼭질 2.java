import java.io.*;
import java.util.*;

public class Main {

    public static int n, k, count=0;
    public static int min = 1234567890;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] check = new int[100001];
        Arrays.fill(check, 1234567890);
        check[n] = 0;

        PriorityQueue<node> pq = new PriorityQueue<>();

        pq.offer(new node(n,0));

        while(!pq.isEmpty()){
            node temp = pq.poll();

            if(temp.t >min){
                break;
            }

            if(temp.x == k){
                min = temp.t;
                count++;
                continue;
            }

            if(temp.x<k){
                if(temp.x*2<100001 && check[temp.x*2] >= temp.t+1){
                    check[temp.x*2] = temp.t+1;
                    pq.offer(new node(temp.x*2, temp.t+1));
                }
                if(temp.x+1<100001 && check[temp.x+1]>=temp.t+1){
                    check[temp.x+1] = temp.t+1;
                    pq.offer(new node(temp.x+1, temp.t+1));
                }
            }
            if(temp.x-1>=0){
                if(check[temp.x-1]>=temp.t+1){
                    check[temp.x-1] = temp.t+1;
                    pq.offer(new node(temp.x-1, temp.t+1));
                }
            }

        }

        System.out.println(min);
        System.out.println(count);


    }

    public static class node implements Comparable<node>{
        int x;
        int t;

        node(int x, int t){
            this.x = x;
            this.t = t;
        }

        @Override
        public int compareTo(node o){
            return this.t-o.t;
        }
    }
}