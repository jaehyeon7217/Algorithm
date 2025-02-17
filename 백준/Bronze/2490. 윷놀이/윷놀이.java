import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String ans = "EABCD";

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int zero = 0;

            for(int j=0;j<4;j++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    zero++;
                }
            }

            sb.append(ans.charAt(zero) + "\n");

        }
        System.out.println(sb);



    }

}
