import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        int[][] road = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            road[start][end] = cost;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (i == X) continue;

            PriorityQueue<XY> list = new PriorityQueue<>();

            list.add(new XY(i, 0));

            int min = Integer.MAX_VALUE;
            int[] check = new int[N];

            for (int j = 0; j < N; j++) {
                check[j] = Integer.MAX_VALUE;
            }
            check[i] = 0;

            while (!list.isEmpty()) {
                XY temp = list.poll();

                if (temp.x == X) {
                    min = Math.min(min, temp.cost);
//                    System.out.println("가는 길 temp.x = "+temp.x + ", temp.cost = " + temp.cost);
                    break;
                }

                for (int j = 0; j < N; j++) {
                    if (road[temp.x][j] != 0 && (check[j] > temp.cost + road[temp.x][j])) {
                        check[j] = temp.cost + road[temp.x][j];
                        list.offer(new XY(j, temp.cost + road[temp.x][j]));
                    }
                }

            }
            int sum = min;

            list = new PriorityQueue<>();

            list.add(new XY(X, 0));

            min = Integer.MAX_VALUE;
            check = new int[N];

            for (int j = 0; j < N; j++) {
                check[j] = Integer.MAX_VALUE;
            }
            check[X] = 0;

            while (!list.isEmpty()) {
                XY temp = list.poll();

                if (temp.x == i) {
                    min = Math.min(min, temp.cost);
//                    System.out.println("오는 길 temp.x = "+temp.x + ", temp.cost = " + temp.cost);
                    break;
                }

                for (int j = 0; j < N; j++) {
                    if (road[temp.x][j] != 0 && (check[j] > temp.cost + road[temp.x][j])) {
                        check[j] = temp.cost + road[temp.x][j];
                        list.offer(new XY(j, temp.cost + road[temp.x][j]));
                    }
                }

            }
            sum += min;
            max = Math.max(max, sum);

        }

        System.out.println(max);


    }

    public static class XY implements Comparable<XY> {
        int x;
        int cost;

        public XY(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }


        @Override
        public int compareTo(XY o) {
            return this.cost - o.cost;
        }
    }

}