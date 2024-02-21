import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_VALUE = 1000000001;
    public static int n, m;
    public static int[][] dis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dis = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dis[i][j] = MAX_VALUE;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            dis[start][end] = Math.min(dis[start][end],cost);

        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j || i==k || j==k) continue;
                    if(dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append((dis[i][j] == MAX_VALUE ? "0" : dis[i][j]) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

}