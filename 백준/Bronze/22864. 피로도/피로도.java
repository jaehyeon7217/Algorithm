import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int now = 0;
        int sum = 0;

        for(int i=0;i<24;i++){

            if(now + a <= m){
                sum += b;
                now += a;
            }else{
                now -= c;
                if(now < 0) now = 0;
            }
        }

        System.out.println(sum);


    }

}