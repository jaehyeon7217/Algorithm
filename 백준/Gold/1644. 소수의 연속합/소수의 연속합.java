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

        Arrays.fill(sosu, true);

        sosu[0] = false;
        sosu[1] = false;

        for(int i=2;i<=n;i++){
            if(!sosu[i]) continue;

            for(int j=i+i; j<=n;j+=i){
                sosu[j] = false;
            }
        }
        int size = 0;
        for(int i=2;i<=n;i++){
            if(sosu[i]) size++;
        }
        int[] arr = new int[size];

        int count = 0;
        for(int i=2;i<=n;i++){
            if(sosu[i]){
                arr[count++] = i;
            }
        }

        int result = 0;
        int start = 0;
        int end = 0;
        int sum = arr[0];
        for(int i=1;i<size;i++){
            sum += arr[i];
            end = i;
            while(sum>n){
                sum-=arr[start++];
            }
            if(sum == n) result++;
        }

        System.out.println(result);

    }


}
