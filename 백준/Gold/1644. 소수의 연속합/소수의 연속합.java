import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static boolean[] sosu;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            System.exit(0);
        }else if(n==2 || n==3){
            System.out.println(1);
            System.exit(0);
        }

        sosu = new boolean[n+1];

        sosu[0] = true;
        sosu[1] = true;

        for(int i=2;i<=n;i++){
            if(sosu[i]) continue;

            for(int j=i+i; j<=n;j+=i){
                sosu[j] = true;
            }
        }
        int size = 283146;
        int[] arr = new int[size];

        int count = 0;
        for(int i=2;i<=n;i++){
            if(!sosu[i]){
                arr[count++] = i;
            }
        }
        size = count;

        int result = 0;
        int start = 0;
        int sum = arr[0];
        for(int i=1;i<size;i++){
            sum += arr[i];
            while(sum>n){
                sum-=arr[start++];
            }
            if(sum == n) result++;
        }

        System.out.println(result);

    }


}
