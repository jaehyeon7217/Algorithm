import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];


        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        HashSet<Integer> hash = new HashSet<>();

        int count = 0;

        for(int i=0;i<n;i++){
            if(hash.contains(x-arr[i])){
                count++;
            }
            hash.add(arr[i]);
        }

        System.out.println(count);



    }

}
