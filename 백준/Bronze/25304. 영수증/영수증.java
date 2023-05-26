import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i=0;i<m;i++){
             st = new StringTokenizer(br.readLine());

             sum += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        }
        System.out.println(sum == n ? "Yes" : "No");


    }
}
