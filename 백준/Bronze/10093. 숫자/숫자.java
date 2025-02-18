import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        if(a>b){
            long temp = a;
            a= b;
            b=temp;
        }

        int count = 0;
        for(long i = a+1; i<b;i++){
            count++;
            sb.append(i+" ");
        }

        System.out.println(count);
        System.out.println(sb);


    }

}
