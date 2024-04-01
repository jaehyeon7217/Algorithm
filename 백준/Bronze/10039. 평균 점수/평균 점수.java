import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;
        for(int i=0;i<5;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp <40) temp=40;
            sum+=temp;
        }
        System.out.println(sum/5);

    }


}