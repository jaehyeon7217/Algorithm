import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][5];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] check = new boolean[n][n];

        for(int j=0;j<5;j++){
            for(int i=0;i<n-1;i++){
                for(int k=i+1;k<n;k++){
                    if(arr[i][j] == arr[k][j]){
                        check[i][k] = true;
                        check[k][i] = true;
                    }
                }
            }
        }
        int num = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(check[i][j]) count++;
            }

            if(sum<count){
                num = i;
                sum = count;
            }
        }

        System.out.println(num+1);



    }


}
