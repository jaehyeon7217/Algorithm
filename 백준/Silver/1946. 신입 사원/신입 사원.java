import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            List<Node> list = new ArrayList<>();


            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new Node(a, b));
            }
            Collections.sort(list, Comparator.comparingInt(o -> o.a));

            int max = list.get(0).b;
            int length = list.size();

            int count = 1;

            for(int i=1; i<length;i++){
                if(list.get(i).b > max) continue;
                count++;
                max = list.get(i).b;
                if(max == 1) break;
            }

            sb.append(count + "\n");


        }
        System.out.println(sb);
    }

    public static class Node {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
