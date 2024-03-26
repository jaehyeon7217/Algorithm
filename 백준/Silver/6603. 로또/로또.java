import java.io.*;
import java.util.*;

public class Main {

    public static int k;
    public static int[] n;
    public static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if( k == 0)
                break;

            n = new int[k];
            check = new boolean[k];
            for(int i=0;i<k;i++){
                n[i] = Integer.parseInt(st.nextToken());
            }

            solve(new StringBuilder(), 0, 0);

            System.out.println();

        }



    }
    public static void solve(StringBuilder sb, int pt, int now){
        if(pt == 6){
            System.out.println(sb.toString());
            return;
        }

        for(int i=now;i<k;i++){
            if(check[i]) continue;
            check[i] = true;
            solve(new StringBuilder().append(sb.toString() + n[i] + " "), pt+1, i+1);
            check[i] = false;

        }



    }


}