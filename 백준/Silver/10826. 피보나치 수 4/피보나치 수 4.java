import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.println(n);
            System.exit(0);
        }

        BigInteger[] num = new BigInteger[n + 1];

        num[0] = new BigInteger("0");
        num[1] = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            num[i] = num[i-1].add(num[i-2]);
        }

        System.out.println(num[n]);


    }


}