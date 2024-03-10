import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i=1;i<=x;i++){
            if(i<100) {
                count++;
                continue;
            }

            char[] s = String.valueOf(i).toCharArray();

            int gap = Integer.parseInt(String.valueOf(s[0]))-Integer.parseInt(String.valueOf(s[1]));
            boolean flag = true;

            for(int j=1;j<s.length-1;j++){
                if(Integer.parseInt(String.valueOf(s[j]))-Integer.parseInt(String.valueOf(s[j+1])) != gap){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }


        }
        System.out.println(count);



    }
}