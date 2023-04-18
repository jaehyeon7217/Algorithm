import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] map, check;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j= 0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                check[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));

    }

    public static int dfs(int x, int y){
        // 도착하면 1
        if(x == n-1 && y == m-1)
            return 1;

        // 이미 끝까지 도달 한 포인트가 있으면 그 값 반환
        if(check[x][y] != -1)
            return check[x][y];

        // -1에서 0으로 초기화
        check[x][y] = 0;

        int value = map[x][y];

        for(int i=0;i<4;i++){
            int a = x + dx[i];
            int b = y + dy[i];

            if(a<0|| a>=n || b<0 || b>=m) continue;
            if(map[a][b] >= value) continue;

            // 끝점과 연결된 포인트 갯수를 합산
            check[x][y] += dfs(a,b);

        }

        // 이 지점에서 끝점으로 가는 갯수 반환
        return check[x][y];
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
