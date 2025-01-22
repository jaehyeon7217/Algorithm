import java.io.*;
import java.util.*;


public class Main {

    public static int arr[], count[];
    public static double sum[];
    public static double result = 0.0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[8];
        count = new int[4];
        sum = new double[4];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0);

        System.out.println(result);


    }

    public static void func(int n) {
        if (n == 8) {
            /*
            12 34, 13 24, 14 23
             */
            result = Math.max(result, satisfaction(sum[0], sum[1], sum[2], sum[3]));
            result = Math.max(result, satisfaction(sum[0], sum[2], sum[1], sum[3]));
            result = Math.max(result, satisfaction(sum[0], sum[3], sum[1], sum[2]));
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (count[i] >= 2) continue;
            count[i]++;
            sum[i] += arr[n];
            func(n + 1);
            sum[i] -= arr[n];
            count[i]--;
        }
    }


    public static double satisfaction(double a, double b, double c, double d) {

        a /= 2;
        b /= 2;
        c /= 2;
        d /= 2;

        double tempA = 1.0 - (Math.abs(a - b) / 10.0);
        double tempB = 1.0 - (Math.abs(c - d) / 10.0);


        return Math.min(tempA, tempB);
    }


}
