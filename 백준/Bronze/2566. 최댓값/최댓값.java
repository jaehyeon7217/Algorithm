import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = 9;
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;


        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (max < value) {
                    max = value;
                    x = i;
                    y = j;
                }

            }
        }

        System.out.println(max);
        System.out.println((x+1) + " " + (y+1));

    }


}