import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int newM = Integer.parseInt(br.readLine());

        int result = h*60 + m + newM;

        System.out.println(((result/60)%24) + " " + (result)%60);

    }
}
