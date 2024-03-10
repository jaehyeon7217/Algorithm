import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int count = 0;

        if(x<100){
            count = x;
        }else if(x==1000){
            count= 144;
        }else{
            count = 99;

            for(int i=100;i<=x;i++){
                int[] num = new int[3];

                num[0] = i/100;
                num[1] = (i%100)/10;
                num[2] = (i%10);

                int gap = num[0]-num[1];
                if(num[1]-num[2] == gap) count++;
            }

        }

        System.out.println(count);



    }
}