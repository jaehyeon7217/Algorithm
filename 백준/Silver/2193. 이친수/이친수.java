import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[91];

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;

        for(int i=4;i<91;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);




        /*
        1 1     1
        2 10    1
        3 100   101     2
        4 1000  1001    1010    3
        5 10000 10001   10010   10100   10101   5
        6 100000    100001  100010  100100  101000  101001  101010 7
          100101
        7 1000000   1000001 1000010 1000100 1001000 1010000   12
            1010001 1010010 1010100 1010101 100101  1001001
         */

    }

}