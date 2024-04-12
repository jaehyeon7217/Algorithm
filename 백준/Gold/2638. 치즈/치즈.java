import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static int x, y;
    public static int[][] map;
    public static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int result = 0;

        map = new int[x+2][y+2];
        int count = 0;
        for(int i=1;i<=x;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=y;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==  1) count++;
            }
        }
        while(count>0){
            result++;
            count=0;
            boolean[][] check = new boolean[x+2][y+2];
            // 외부공기 체크
            Queue<node> q = new LinkedList<>();
            q.offer(new node(0,0));
            check[0][0] = true;

            while(!q.isEmpty()){
                node temp = q.poll();
                for(int i=0;i<4;i++){
                    int tx = temp.x+dx[i];
                    int ty = temp.y+dy[i];
                    if(tx<0 || tx>=x+2 || ty<0 || ty>=y+2) continue;
                    if(map[tx][ty] == 1 || check[tx][ty]) continue;

                    check[tx][ty] = true;
                    q.offer(new node(tx, ty));
                }
            }


            for(int i=1;i<=x;i++){
                for(int j=1; j<=y;j++){
                    if(map[i][j] == 1){
                        int checkCount= 0;
                        for(int k=0;k<4;k++){
                            int tempX = i+dx[k];
                            int tempY = j+dy[k];

                            if(tempX<1 || tempX>=x+1 || tempY<1 || tempY>=y+1) continue;
                            if(map[tempX][tempY] == 0 && check[tempX][tempY]) checkCount++;
                        }
                        if(checkCount>1) check[i][j] = true;
                        else{
                            count++;
                        }
                    }
                }
            }

            for(int i=1;i<=x;i++){
                for(int j=1; j<=y;j++) {
                    if(map[i][j] == 0) check[i][j] = true;
                }
            }

            map = new int[x+2][y+2];
            for(int i=0;i<x+2;i++){
                for(int j=0;j<y+2;j++){
                    if(!check[i][j]) map[i][j] = 1;
                }
            }
        }

        System.out.println(result);


    }
    public static class node{
        int x, y;
        node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void pr(){
        System.out.println();
        for(int i=0;i<x+2;i++){
            for(int j=0;j<y+2;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pr_check(boolean[][] check){
        System.out.println();
        for(int i=0;i<x+2;i++){
            for(int j=0;j<y+2;j++){
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



}