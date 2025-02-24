import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for(int j = leftX; j<rightX ; j++){
                for(int l = leftY ; l < rightY ;l++){
                    map[j][l] = -1;
                }
            }
        }
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 0){
                    Queue<node> q = new LinkedList<>();
                    q.offer(new node(i,j));
                    map[i][j] = ++count;
                    int tempCount = 0;
                    while(!q.isEmpty()){
                        node temp = q.poll();
                        tempCount++;

                        for(int l=0; l<4;l++){
                            int x = temp.x + dx[l];
                            int y = temp.y + dy[l];

                            if(x<0 || x>=n || y<0 || y>=m) continue;
                            if(map[x][y] != 0) continue;

                            map[x][y] = count;
                            q.offer(new node(x,y));
                        }
                    }
                    ans.add(tempCount);
                }
            }
        }

        Collections.sort(ans);
        sb.append(count + "\n");
        for(int a : ans){
            sb.append(a+" ");
        }

        System.out.println(sb);

    }

    public static void pr(int n, int m, int[][] map){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
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