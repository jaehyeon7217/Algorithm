import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, r, c;
    public static char[][] map;
    public static boolean[][] check;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        check = new boolean[n][m];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        Queue<Node> q = new LinkedList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check[i][j]) continue;
                if(map[i][j] == '#')continue;
                check[i][j] = true;

                q.offer(new Node(i,j));
                int rTemp = 0;
                int cTemp = 0;
                if(map[i][j] =='o') rTemp++;
                else if(map[i][j] == 'v') cTemp++;
                while(!q.isEmpty()){
                    Node temp = q.poll();

                    for(int k=0;k<4;k++){
                        int x = temp.x + dx[k];
                        int y = temp.y + dy[k];

                        if(x<0 || x>=n || y<0 || y>=m) continue;
                        if(check[x][y]) continue;
                        check[x][y] = true;
                        if(map[x][y] == '#') continue;
                        if(map[x][y] =='o') rTemp++;
                        if(map[x][y] =='v') cTemp++;

                        q.offer(new Node(x,y));
                    }
                }

                if(rTemp>cTemp) cTemp = 0;
                else rTemp=0;

                c += cTemp;
                r += rTemp;

            }
        }

        System.out.println(r+ " " + c);



    }

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
