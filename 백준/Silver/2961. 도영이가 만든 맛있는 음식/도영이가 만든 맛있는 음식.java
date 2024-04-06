import java.io.*;
import java.util.*;

public class Main {

    public static int n, min= Integer.MAX_VALUE;
    public static int[][] food;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        food = new int[n][2];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
            min = Math.min(Math.abs(food[i][0]- food[i][1]),min);
        }

        for(int i=2;i<=n;i++){
            func(0,i,1,0,0);
        }

        System.out.println(min);



    }

    public static void func(int step, int pick, int sin, int dan, int now){
        if(pick == step){
            min = Math.min(Math.abs(sin-dan), min);
            return;
        }

        for(int i=now; i<n;i++){
            func(step+1, pick, sin*food[i][0], dan+food[i][1], i+1);
        }

    }



}