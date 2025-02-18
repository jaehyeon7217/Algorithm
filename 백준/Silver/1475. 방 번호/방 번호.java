import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();

        int[] arr = new int[9];

        for(int i=0;i<c.length;i++){
            int temp = c[i] - '0';
            if(temp == 9) {
                temp = 6;
            }

            arr[temp]++;
        }

        int max = 0;
        for(int i=0;i<9;i++){
            int temp = arr[i];
            if(i==6){

                temp = arr[i] %2 == 0 ? temp/2 : temp/2 + 1;
            }

            max = Math.max(max, temp);
        }

        System.out.println(max);


    }


}
