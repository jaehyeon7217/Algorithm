import java.io.*;
import java.util.*;

public class Main {

    public static int n,m,k,x;
    public static ArrayList<Integer>[] list;
    public static int[] target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken())-1;

        list = new ArrayList[n];
        target = new int[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
            target[i] = 1234567890;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            list[start].add(end);
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        target[x] = 0;
        while(!q.isEmpty()){
            int temp = q.poll();

            int size = list[temp].size();

            for(int i=0;i<size;i++){
                int next = list[temp].get(i);
                if(target[temp]+1 >target[next]) continue;
                target[next] = target[temp]+1;
                q.offer(next);
            }
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(target[i] == k){
                count++;
                sb.append((i+1) + "\n");
            }
        }

        System.out.println(count==0? "-1" : sb.toString());




    }



}