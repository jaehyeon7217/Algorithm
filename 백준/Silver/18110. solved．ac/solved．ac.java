import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] map = new int[n];

        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(map);

        int num = (int)Math.round(n*0.15);

        int sum = 0;

        for(int i=num;i<n-num;i++){
            sum+=map[i];
        }
        System.out.println((int)Math.round(sum/(n - (num*2.0))));

    }

}
