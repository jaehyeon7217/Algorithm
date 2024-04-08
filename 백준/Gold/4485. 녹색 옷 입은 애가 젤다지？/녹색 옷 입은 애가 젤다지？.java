import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static final int max = 1234567890;
    public static int[][] map, check;
    public static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = 1;
        while(true){
            n = Integer.parseInt(br.readLine());

            // 종료
            if(n == 0) break;

            map = new int[n][n];
            check = new int[n][n];

            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    check[i][j] = max;
                }
            }

            Queue<node> q = new LinkedList<>();
            q.offer(new node(0,0));
            check[0][0] = map[0][0];

            while(!q.isEmpty()){
                node temp = q.poll();

                for(int i=0;i<4;i++){
                    int x = temp.x + dx[i];
                    int y = temp.y + dy[i];

                    if(x <0 || x>=n || y<0 || y>=n) continue;
                    if(check[x][y] <= check[temp.x][temp.y] + map[x][y]) continue;

                    check[x][y] = check[temp.x][temp.y] + map[x][y];
                    q.offer(new node(x,y));
                }
            }

            sb.append("Problem ").append(t).append(": ").append(check[n-1][n-1]).append("\n");
            t++;

        }

        System.out.println(sb.toString());
    }

    public static class node{
        int x;
        int y;
        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}