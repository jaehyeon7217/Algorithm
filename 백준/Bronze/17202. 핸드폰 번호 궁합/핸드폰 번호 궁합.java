import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        char[] sum = new char[16];

        for (int i = 0; i < 8; i++) {
            sum[i * 2] = a[i];
            sum[i * 2 + 1] = b[i];
        }
        solve(sum);
    }

    public static void solve(char[] c) {
        int length = c.length;
        if (length == 2) {
            System.out.println(c);
            return;
        }

        char[] next = new char[length - 1];

        for (int i = 0; i < length - 1; i++) {
            int a = c[i] - '0';
            int b = c[i + 1] - '0';

            next[i] = (char) (((a + b) % 10) + '0');
        }
        solve(next);
    }
}