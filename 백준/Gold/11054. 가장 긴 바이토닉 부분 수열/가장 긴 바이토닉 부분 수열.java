import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] up = new int[n];
        int[] down = new int[n];
        down[n-1] = 1;

        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j=i-1;j>=0;j--){
                if(num[i]>num[j]){
                    flag = false;
                    up[i] = Math.max(up[i], up[j] +1);
                }
            }
            if(flag){
                up[i] = 1;
            }
        }
        for(int i=n-1;i>=0;i--){
            boolean flag = true;
            for(int j=i+1; j<n;j++){
                if(num[i]>num[j]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                    flag = false;
                }

            }
            if(flag){
                down[i] = 1;
            }
        }

        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, up[i] + down[i] -1);
        }


        System.out.println(max);

    }
}