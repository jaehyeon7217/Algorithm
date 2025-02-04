import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double s = Double.parseDouble(br.readLine());

        int count = 0;
        for(double i=1;i<s/2.0;i++){
            if(s <= i) break;
            s-=i;
            count++;
        }

        System.out.println(count+1);

    }

}
