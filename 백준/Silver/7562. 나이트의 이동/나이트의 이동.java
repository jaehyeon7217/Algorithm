import java.util.*;
import java.io.*;

public class Main {

    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n][n];

            st = new StringTokenizer(br.readLine(), " ");

            node start = new node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine(), " ");

            node end = new node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            Queue<node> q = new LinkedList<>();
            q.offer(start);
            map[start.x][start.y] = 1;

            while(!q.isEmpty()){
                node temp = q.poll();

                for(int i=0;i<8;i++){
                    int x = temp.x + dx[i];
                    int y = temp.y + dy[i];

                    if(x<0 || x>=n || y<0 || y>=n) continue;
                    if(map[x][y] != 0) continue;

                    map[x][y] = map[temp.x][temp.y] + 1;

                    if(x == end.x && y==end.y){
                        q.clear();
                        break;
                    }

                    q.offer(new node(x,y));
                }
            }

            sb.append((map[end.x][end.y]-1) + "\n");

        }

        System.out.println(sb);


    }

    public static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



}
