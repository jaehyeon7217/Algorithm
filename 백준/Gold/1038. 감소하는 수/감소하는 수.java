import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n<11){
            System.out.println(n);
            System.exit(0);
        }
        if(n>1022){
            System.out.println("-1");
            System.exit(0);
        }
        if(n==1022){
            System.out.println("9876543210");
            System.exit(0);
        }

        int[][] arr = new int[10][10];
        for(int i=0;i<10;i++){
            arr[0][i] = 1;
        }

        for(int i=1;i<10;i++){
            for(int j=i;j<10;j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j-1];
            }
        }

        int[][] dp = new int[10][10];

        for(int i=0;i<10;i++){
            dp[0][i] = i;
        }

        int a = 0;
        int b = 0;
        int count = 0;

        bp : for(int i=1;i<10;i++){
            dp[i][i]= dp[i-1][9] + arr[i][i];

            for(int j=i+1;j<10;j++){
                dp[i][j] = dp[i][j-1] + arr[i][j];
                if(n<=dp[i][j]){
                    a=i;
                    b=j;
                    count = dp[i][j]+1;
                    break bp;
                }
            }
        }

        for(long num = (b+1)*(long)Math.pow(10.0,a)-1; num>=(b)*(long)Math.pow(10.0,a); num--){
            char[] array = String.valueOf(num).toCharArray();
            boolean flag = true;
            for(int j=0;j<array.length-1;j++){
                if( (array[j]-'0') <= (array[j+1] -'0')){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count--;
            }
            if(count==n){
                System.out.println(num);
                System.exit(0);
            }
        }

    }

}
