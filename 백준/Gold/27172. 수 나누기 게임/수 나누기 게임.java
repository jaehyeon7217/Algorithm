import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[] arr, result;
    public static final int max = 1_000_001;
    public static boolean[] all = new boolean[max];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        result = new int[max];
        int maxRange = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            all[arr[i]]=true;
            maxRange = Math.max(maxRange, arr[i]);
        }

        for(int i : arr){
            for(int j=i+i;j<max;j+=i){
                if(!all[j]) continue;

                result[i]++;
                result[j]--;

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(result[arr[i]] + " ");
        }
        System.out.println(sb);


    }


}
