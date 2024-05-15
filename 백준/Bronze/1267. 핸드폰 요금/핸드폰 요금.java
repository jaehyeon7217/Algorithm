import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int Y=0;
        int M=0;

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            Y += (temp/30)*10 + 10;
            M += (temp/60)*15 + 15;
        }

        if(Y==M){
            System.out.println("Y M " + Y);
        }else if(Y<M){
            System.out.println("Y " + Y);
        }else{
            System.out.println("M "+ M);
        }


    }

}