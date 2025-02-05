import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<k;i++){
            int temp = Integer.parseInt(st.nextToken());

            temp = (temp*100)/n;

            if(0<=temp && temp<=4) sb.append("1 ");
            else if(temp<=11) sb.append("2 ");
            else if(temp<=23) sb.append("3 ");
            else if(temp<=40) sb.append("4 ");
            else if(temp<=60) sb.append("5 ");
            else if(temp<=77) sb.append("6 ");
            else if(temp<=89) sb.append("7 ");
            else if(temp<=96) sb.append("8 ");
            else sb.append("9 ");

        }

        System.out.println(sb);



    }

}
