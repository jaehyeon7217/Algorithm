import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] map;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0 ; k<n; k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                        map[i][j] = map[i][k] + map[k][j] == 2 ? 1 : map[i][j];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(map[i][j] + " ");
            }
           sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}
