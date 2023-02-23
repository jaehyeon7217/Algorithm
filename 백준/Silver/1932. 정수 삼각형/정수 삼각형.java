import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{

    public static int n, result;
    public static int[][] map, check;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new int[n][n];
        result = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check[0][0] = map[0][0];

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j-1>=0){
                    check[i][j] = Math.max(check[i][j], check[i-1][j-1] + map[i][j]);
                }
                if(j<=i-1){
                    check[i][j] = Math.max(check[i][j], check[i-1][j] + map[i][j]);
                }
            }
        }


        for(int i=0;i<n;i++){
            result =  Math.max(check[n-1][i],result);
        }

        System.out.println(result);
    }


}