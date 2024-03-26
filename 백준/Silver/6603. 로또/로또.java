import java.io.*;
import java.util.*;

public class Main {

    public static int k;
    public static int[] n;
    public static int[] pick;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if( k == 0)
                break;

            n = new int[k];
            pick = new int[6];
            for(int i=0;i<k;i++){
                n[i] = Integer.parseInt(st.nextToken());
            }

            solve(0, 0);

            sb.append("\n");

        }
        System.out.println(sb.toString());



    }
    public static void solve(int pt, int now){
        if(pt == 6){
            for(int i : pick){
                sb.append(i + " ");
            }

            sb.append("\n");

            return;
        }

        for(int i=now;i<k;i++){
            pick[pt] = n[i];
            solve(pt+1, i+1);

        }



    }


}