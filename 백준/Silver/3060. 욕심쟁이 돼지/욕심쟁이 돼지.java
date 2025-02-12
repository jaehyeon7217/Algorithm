import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());

            int sum=0;

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<6;i++){
                sum += Integer.parseInt(st.nextToken());
            }
            int count=1;
            while(sum<=n){
                count++;
                sum*=4;
            }

            sb.append(count+"\n");

        }
        System.out.println(sb);

    }



}
