import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = 101;

        int sum = 0;

        for(int i=0;i<4;i++){
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            min = Math.min(min, temp);
        }
        sum -=min;
        min=101;

        for(int i=0;i<2;i++){
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            min = Math.min(min, temp);
        }
        sum -=min;
        System.out.println(sum);

    }

}
