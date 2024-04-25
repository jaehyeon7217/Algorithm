import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            if(m==0 && f==0) break;

            sb.append((f+m)+ "\n");

        }

        System.out.println(sb);

    }

}
