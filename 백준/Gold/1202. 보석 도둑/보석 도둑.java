import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //보석 정보

        List<Node> list = new LinkedList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Node(m,v));
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.m)); // (o1,o2) -> (o1.m-o2.m)



        int[] bag = new int[k];

        for(int i=0;i<k;i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> (o2.v - o1.v));
        long ans = 0;

        for(int i=0;i<k;i++){

            for(int j=0;j<list.size();j++){
                if(bag[i] < list.get(j).m) break;

                queue.offer(new Node(list.get(j).m, list.get(j).v));
                list.remove(j);
                j--;
            }

            if(queue.isEmpty()) continue;
            Node temp = queue.poll();

            ans += temp.v;

        }

        System.out.println(ans);


    }

    public static class Node{
        int m;
        int v;

        public Node(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }

}
