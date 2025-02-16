import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println( (int)(n-(n*0.22)) + " " + (int)(n-(n*0.2*0.22))  );
    }

}
