import java.util.*;
import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);
    public static StringBuilder sb = new StringBuilder();

    public static int n,m, map[][];


    public static void main(String[] args) throws Exception {
        init();

        int count = 0;
        // 녹이고 체크 녹이고 체크
        while(true){
            count++;
            melt();
            int ans = test();
            if(ans >1){
                System.out.println(count);
                break;
            }else if(ans==0){
                System.out.println(0);
                break;
            }
        }


    }
    public static void init() throws Exception{
        n=nextInt();
        m=nextInt();

        map = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = nextInt();
            }
        }
    }

    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};

    public static void pr(){
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void melt(){

        boolean[][] check = new boolean[n][m];
        int[][] temp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check[i][j]) continue;
                check[i][j] = true;

                if(map[i][j] != 0){
                    for(int k=0;k<4;k++){
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if(range(x,y)) continue;
                        if(map[x][y] == 0){
                            temp[i][j]++;
                        }
                    }

                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] -= temp[i][j];
                if(map[i][j] < 0) map[i][j] =0;
            }
        }

    }

    public static boolean range(int x, int y){
        return x<0 || x>=n || y<0 || y>=m;
    }

    public static int test(){
        int[][] temp = new int[n][m];

        int count =1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] != 0 && temp[i][j] == 0){
                    temp[i][j] = count;
                    Queue<node> q = new LinkedList<>();
                    q.offer(new node(i,j));

                    while(!q.isEmpty()){
                        node t = q.poll();

                        for(int k=0;k<4;k++){
                            int x = t.x + dx[k];
                            int y = t.y + dy[k];

                            if(range(x,y))continue;
                            if(map[x][y] ==0 )continue;
                            if(temp[x][y] != 0) continue;
                            temp[x][y] = count;
                            q.offer(new node(x,y));

                        }
                    }
                    count++;
                }
            }
        }

        return count-1;
    }

    public static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static String next() throws Exception {
        st.nextToken();
        return st.sval;
    }

}
