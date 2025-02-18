import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int i = 0;

        boolean flag = true;

        while (true) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = i; j < n - 1; j++) {
                sb.append("*");
            }
            sb.append("*");
            for (int j = n - 1; j > i; j--) {
                sb.append("*");
            }
            sb.append("\n");

            if (i == n-1) {
                flag = false;
            }
            if (flag) {
                i++;
            } else {
                i--;
            }

            if (!flag && i == -1) break;
        }


        System.out.print(sb);

    }


}
