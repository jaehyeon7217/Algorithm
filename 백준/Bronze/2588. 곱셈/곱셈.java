import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int a = m/100;
        int b = (m/10)%10;
        int c = m%10;

        System.out.println((n*c) +"\n"+ (n*b) +"\n"+ (n*a) + "\n" + (n*m) );

    }
}
