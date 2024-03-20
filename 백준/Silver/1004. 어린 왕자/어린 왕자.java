import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int T = 0; T<t ; T++){
            st = new StringTokenizer(br.readLine());

            int[][] pt = new int[2][2];

            // 시작점 ([0][0], [0][1]), 끝점 ([1][0], [1][1])
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    pt[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int[] point = new int[2];

                for(int j=0;j<2;j++){
                    point[j] = Integer.parseInt(st.nextToken());
                }

                int radius = Integer.parseInt(st.nextToken());

                int start = calc(pt[0], point);
                int end = calc(pt[1], point);

                boolean sp = false;
                boolean ep = false;

                if(start <= (int)Math.pow(radius, 2.0))
                    sp = true;
                if(end <= (int)Math.pow(radius, 2.0))
                    ep = true;

                if(sp ^ ep){
                    count++;
                }
            }
            sb.append(count + " \n");



        }

        System.out.println(sb.toString());

    }

    public static int calc(int[] pt1, int[] pt2){

        int[] xy = new int[2];

        for(int i=0;i<2;i++){
            xy[i] = pt2[i] - pt1[i];
            xy[i] = (int)Math.pow(xy[i], 2.0);
        }

        return xy[0] + xy[1];

    }


}