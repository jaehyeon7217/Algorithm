import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long b;
    public static final int div = 1000;
    public static int[][] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        a = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = calc(b);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append((result[i][j]%div) +  " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static int[][] calc(long step){
        if(step == 1){
            return a;
        }

        int[][] temp = calc(step/2);
        if(step%2==0){
            return zegob(temp, temp);
        }else{
            return zegob(zegob(temp, temp),a);
        }
    }

    public static int[][] zegob(int[][] one, int[][] two){
        int[][] temp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                for(int k=0;k<n;k++){
                    sum += ((one[i][k]%div) * (two[k][j]%div))%div;
                }

                temp[i][j] = sum%div;
            }

        }

        return temp;
    }

}