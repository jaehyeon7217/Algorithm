import java.io.*;
import java.util.*;
public class Main {
    public static int n, m, r;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        int[][] result = new int[n][n];


        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 100;
                result[i][j] = 100;
            }
        }

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            list.add(Integer.parseInt(st.nextToken()));

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());
            map[x][y] = value;
            map[y][x] = value;
        }

        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    result[i][j] = Math.min(result[i][j],Math.min(map[i][j], result[i][k] + result[k][j]));

        int resultNum = 0;
        for(int i=0;i<n;i++){
            int temp = list.get(i);
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(result[i][j]<=m)
                    temp+= list.get(j);

            }
            resultNum= Math.max(resultNum,temp);
        }

        System.out.println(resultNum);

    }
}