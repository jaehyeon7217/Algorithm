import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {/// t번 만큼 반복 시작
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int gap = e - s;

            int max = (int)Math.sqrt(gap);

            if(gap == max*max)
                sb.append(((max*2) - 1) + "\n");
            else if(gap <= max*max + max)
                sb.append(max*2+ "\n");
            else
                sb.append(max*2+1+ "\n");

        }// t번 만큼 반복 끝

        System.out.println(sb.toString());


    }
}