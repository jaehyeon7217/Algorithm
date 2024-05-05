import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n];

        int pt = 0;

        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int order = Integer.parseInt(st.nextToken()) - 1;

            int min = 1234567890;

            int temp = pt;
            int count = 0;

            // left
            while (true) {
                if (temp == order) {
                    min = Math.min(min, count);
                    break;
                }
                temp -= 1;
                if (temp < 0) {
                    temp = n - 1;
                }
                if (!check[temp]) {
                    count++;
                }
            }
            temp = pt;
            count = 0;

            //right
            while (true) {
                if (temp == order) {
                    min = Math.min(min, count);
                    break;
                }
                temp += 1;
                if (temp >= n) {
                    temp = 0;
                }
                if (!check[temp]) {
                    count++;
                }
            }

            pt = order;
            while (true) {
                pt += 1;
                if(pt>=n) pt=0;
                if (!check[pt]) break;
            }
            check[order] = true;
            result += min;

        }
        System.out.println(result);


    }

}
