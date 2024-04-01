import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = 1;

        while(true){
            if(b == a){
                System.out.println(sum);
                break;
            }
            if(b == 0){
                System.out.println(-1);
                break;
            }

            if(b%2 == 1){
                if(b%10 == 1)
                    b/=10;
                else b = 0;
            }else{
                b/=2;
            }
            sum++;

        }


    }



}