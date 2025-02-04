import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] list = new int[n+1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a]=b;
            }

            int max = list[1];

            int count = 1;

            for(int i=2; i<=n;i++){
                if(list[i] > max ) continue;
                count++;
                max = list[i];
                if(max == 1) break;
            }

            sb.append(count + "\n");


        }
        System.out.println(sb);
    }

}
