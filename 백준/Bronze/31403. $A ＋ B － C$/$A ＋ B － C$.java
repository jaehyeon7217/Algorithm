import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);

        sb.append(a).append(b);

        System.out.println(a1+b1-c1);
        System.out.println( Integer.parseInt(sb.toString()) - c1 );
    }
}
