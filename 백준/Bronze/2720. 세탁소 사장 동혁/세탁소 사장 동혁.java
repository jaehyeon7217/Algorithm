import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0;t<T;t++){
            int c = Integer.parseInt(br.readLine());

            int q=0,d=0,n=0,p=0;

            while(c>=25){
                c-=25;
                q++;
            }
            while(c>=10){
                c-=10;
                d++;
            }
            while(c>=5){
                c-=5;
                n++;
            }
            while(c>=1){
                c-=1;
                p++;
            }

            sb.append(q + " " + d+ " " +n+ " " +p+"\n");

        }

        System.out.println(sb);

    }

}
