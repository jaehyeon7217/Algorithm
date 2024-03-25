import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minA = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            minA = Math.min(minA, Integer.parseInt(br.readLine()));
        }

        int minB = Integer.MAX_VALUE;
        for(int i=0;i<2;i++){
            minB = Math.min(minB, Integer.parseInt(br.readLine()));
        }

        System.out.println((minA + minB -50));


    }


}