import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] size = new int[6];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++){
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i=0;i<6;i++){
            if(size[i] == 0 )continue;
            if(size[i] % t == 0){
                size[i] -= 1;
            }
            size[i] = size[i]/t +1;

            sum += size[i];
        }

        System.out.println(sum);
        System.out.println( (n/p) + " " + (n%p) );

    }
}
