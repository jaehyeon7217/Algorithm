import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] map;
    public static boolean[][] check;
    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};
    public static int max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];

        // 입력

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 계산
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                check[i][j] = true;
                dfs(1,map[i][j],i,j);
                check[i][j] = false;

                bfs(i,j);

            }
        }

        System.out.println(max);

    }

    public static void bfs(int cx, int cy){
        int sum = map[cx][cy];
        int count = 0;

        for(int i=0;i<4;i++){
            int x = cx + dx[i];
            int y = cy + dy[i];

            if(x <0 || x>=n || y<0 || y>= m) continue;

            sum += map[x][y];
            count++;
        }

        if(count == 3){
            max = Math.max(max,sum);
            return;
        }else if(count < 3)
            return;


        for(int i=0;i<4;i++){
            int x = cx + dx[i];
            int y = cy + dy[i];

            if(x <0 || x>=n || y<0 || y>= m) continue;
            if(count - 1 != 3) continue;
            max = Math.max(max, sum - map[x][y]);
        }


    }

    public static void dfs(int count, int sum, int cx, int cy){
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<4;i++){
            int x = cx + dx[i];
            int y = cy + dy[i];

            if(x <0 || x>=n || y<0 || y>= m) continue;
            if(check[x][y]) continue;

            check[x][y] = true;

            dfs(count+1, sum + map[x][y], x,y);

            check[x][y] = false;
        }
    }
}
