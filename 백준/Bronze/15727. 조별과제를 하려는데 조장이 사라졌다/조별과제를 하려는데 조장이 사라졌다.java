import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result= n/5;
        if(n%5 != 0) {
            result++;
        }

        System.out.println( result );


    }
}
