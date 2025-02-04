import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int c = Integer.parseInt(br.readLine());

            int q = c / 25;
            c %= 25;
            int d = c / 10;
            c %= 10;
            int n = c/5;
            c %= 5;
            int p = c;


            sb.append(q + " " + d + " " + n + " " + p + "\n");

        }

        System.out.println(sb);

    }

}
