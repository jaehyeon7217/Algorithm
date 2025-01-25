import java.io.*;
import java.util.*;


public class Main {

    public static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        ArrayList<Node> node = new ArrayList<>();
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            return o1.t - o2.t;
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            node.add(new Node(s, t));
            q.offer(new Node(s, t));

        }

        Collections.sort(node, ((o1, o2) -> {
            return o1.s - o2.s;
        }));

        int size = 0;
        int pt = 0;
        int nowSize = 0;

        while(!q.isEmpty()){  // 끝나는 시간
            Node temp = q.poll();
            int tempSize = nowSize;

            for(int i=pt;i<n;i++){  // 시작시간
                if(node.get(i).s >= temp.t){
                    size = Math.max(size, tempSize);
                    pt = i;
                    nowSize = tempSize-1;

                    break;
                }
                tempSize++;
            }
        }

        System.out.println(size);


    }

    public static class Node {
        int s;
        int t;

        public Node(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
