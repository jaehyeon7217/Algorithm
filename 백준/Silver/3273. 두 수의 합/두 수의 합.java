import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] check = new boolean[1_000_001];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            check[arr[i]] = true;
        }

        int x = Integer.parseInt(br.readLine());


        int count = 0;

        for(int i=0;i<n;i++){
            int temp = x-arr[i];
            if(temp<0 || temp>1000000) continue;
            if(check[temp]){
                count++;
            }
        }

        System.out.println(count/2);



    }

}
