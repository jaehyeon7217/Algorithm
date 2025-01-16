import java.io.*;
import java.util.*;


public class Main {

    public static int sum=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());



        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");

            int w = Integer.parseInt(st.nextToken());

            switch(w){
                case 136 : add(1000); break;
                case 142 : add(5000); break;
                case 148 : add(10000); break;
                case 154 : add(50000); break;
            }

        }

        System.out.println(sum);


    }

    public static void add(int n){
        sum+=n;
    }
}
