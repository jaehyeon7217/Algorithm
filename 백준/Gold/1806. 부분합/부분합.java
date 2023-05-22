import java.io.*;
import java.util.*;

public class Main {

    public static int[] map;

    public static int count = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = 0;
        int right = 0;
        int length = 0;

        while(true){
            if(sum>=m){
                count = Math.min(count, length);
                sum -= map[left++];
                length--;
            }else if(sum<m ) {
                if (right < n) {
                    sum += map[right++];
                    length++;
                } else if (right == n) {
                    sum -= map[left++];
                    length--;
                }
            }

            if(left == n) break;
        }

        System.out.println(count > 123456789 ? 0 : count);

    }

}
