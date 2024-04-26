import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int n = 0;
        int sum = 0 ;

        while(sum<x){
            n++;
            sum+=n;
        }

        if( sum == x){
            if(n%2==0)
            System.out.println(n+"/1");
            else
                System.out.println("1/"+n);
        }else{
            x -= (sum - n);
            if(n%2==0) {
                System.out.println((x + "/" + (n - x + 1)));
            }else{
                System.out.println(((n - x + 1) + "/" + x));

            }

        }

    }

}
