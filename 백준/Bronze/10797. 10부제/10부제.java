import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i=0;i<5;i++){
            if(Integer.parseInt(st.nextToken()) == m) count++;
        }
        System.out.println(count);

    }


}
