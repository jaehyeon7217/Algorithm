import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;
    public static boolean[][] clean;
    public static int n,m, d, count=0;

    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n * m 배열
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        // 청소 여부
        clean = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        Queue<Node> q = new LinkedList<>();
        // 초기 위치
        q.offer(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!q.isEmpty()){
            Node temp = q.poll();

            // 벽이 아니고 청소가 안되어 있을 때 청소
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(map[temp.x][temp.y] == 0 && !clean[temp.x][temp.y]) {
                clean[temp.x][temp.y] = true;
                count++;
            }

            boolean exist = false;

            for(int i=0;i<4;i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];

                // 범위 밖은 제외
                if(x<0 || y<0 || x>=n || y>= m) continue;
                // 벽이거나 청소 되었으면 제외
                if(map[x][y] == 1 || clean[x][y]) continue;

                exist = true;
                break;
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if(!exist){
                int x = temp.x + dx[(temp.d+2)%4];
                int y = temp.y + dy[(temp.d+2)%4];

                // 범위 밖은 제외
                if(x<0 || y<0 || x>=n || y>= m) break;
                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if(map[x][y] == 1) break;
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                q.offer(new Node(x,y,temp.d));
            }else{
                // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                // 반시계 방향으로 90도 회전한다.
                int newD = temp.d == 0 ? 3 : temp.d-1;
                int x = temp.x + dx[newD];
                int y = temp.y + dy[newD];

                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                // 범위 밖이거나 벽이거나 청소 되었으면 현위치
                if(x<0 || y<0 || x>=n || y>= m ||map[x][y] == 1 || clean[x][y]) {
                    //범위 밖이면 이동 못하니까 현위치
                    q.offer(new Node(temp.x, temp.y, newD));
                    continue;
                }

                // 전진
                q.offer(new Node(x,y,newD));
            }
        }
        System.out.println(count);

    }

    public static class Node{
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
