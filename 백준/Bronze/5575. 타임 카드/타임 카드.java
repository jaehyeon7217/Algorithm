import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws Exception {

            func();
            func();
            func();

        System.out.println(sb);

    }

    public static void func() throws Exception {
        int startH, startM, startS, endH, endM, endS, resultH, resultM;

        st = new StringTokenizer(br.readLine());
        startH = Integer.parseInt(st.nextToken());
        startM = Integer.parseInt(st.nextToken());
        startS = Integer.parseInt(st.nextToken());
        endH = Integer.parseInt(st.nextToken());
        endM = Integer.parseInt(st.nextToken());
        endS = Integer.parseInt(st.nextToken());

        int start, end, result;

        start = (startH * 3600) + (startM * 60) + startS;
        end = (endH* 3600 ) + (endM * 60) + endS;
        result = end-start;
        resultH = result/3600;
        result %= 3600;
        resultM = result/60;
        result %=60;

        sb.append(resultH + " " + resultM + " " +result + "\n");

    }


}
