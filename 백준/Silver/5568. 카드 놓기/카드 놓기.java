import java.io.*;
import java.util.*;


public class Main {

    public static int n, k;
    public static int[] num;
    public static boolean[] check;
    public static HashMap<String, Integer> hash;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        num = new int[n];
        check = new boolean[n];
        hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        func(0, new StringBuilder());

        System.out.println(hash.size());


    }

    public static void func(int step, StringBuilder sb) {
        if (step == k) {
            int temp = hash.getOrDefault(sb.toString(), -1);
            if (temp < 0) {
                hash.put(sb.toString(), 1);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            StringBuilder next = new StringBuilder();
            next.append(sb.toString()).append(num[i]);
            check[i] = true;
            func(step + 1, next);
            check[i] = false;
        }


    }

}