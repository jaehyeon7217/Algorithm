import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[][] map;
    public static int[][] result;
    public static Queue<xy> q = new LinkedList<>();
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;
                if(map[i][j] == 2) {
                    q.offer(new xy(i,j));
                    result[i][j] = 0;
                }
                if(map[i][j] == 0) result[i][j] = 0;

            }
        }

        while(!q.isEmpty()){
            xy temp = q.poll();

            for(int i=0;i<4;i++){
                int x = temp.x+dx[i];
                int y = temp.y+dy[i];

                if(x<0||x>=n||y<0||y>=m) continue;
                if(map[x][y] != 1) continue;
                if(result[x][y] != -1) continue;

                result[x][y] = result[temp.x][temp.y] + 1;
                q.offer(new xy(x,y));

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    public static class  xy{
        int x;
        int y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
