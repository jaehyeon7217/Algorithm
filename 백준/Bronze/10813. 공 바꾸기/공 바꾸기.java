import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] map = new int[n];

        for(int i=0;i<n;i++){
            map[i] = i+1;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            if(start == end) continue;

            int temp = map[start];
            map[start] = map[end];
            map[end] = temp;

        }

        for(int i=0;i<n;i++){
            sb.append(map[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
