import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int x = (a+b)/2;
        int y = (a-b)/2;

        if(x+y !=a || x-y !=b || x<0 || y<0){
            System.out.println("-1");
        }else{
            System.out.println(x>y ? (x+ " " + y) : (y + " " + x));
        }

    }


}