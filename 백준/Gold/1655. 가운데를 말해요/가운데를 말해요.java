import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q1 = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        PriorityQueue<Integer> q2 = new PriorityQueue<>(((o1, o2) -> (o1 - o2)));


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                q1.offer(num);
            } else {
                q2.offer(num);
            }

            if (!q1.isEmpty() && !q2.isEmpty()) {
                if (q1.peek() > q2.peek()) {
                    int temp = q1.poll();
                    q1.offer(q2.poll());
                    q2.offer(temp);
                }
            }

            sb.append(q1.peek()).append("\n");

        }

        System.out.println(sb.toString());

    }


}