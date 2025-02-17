import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int zero = 0;
            int one = 0;

            for(int j=0;j<4;j++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    zero++;
                } else {
                    one++;
                }
            }

            switch(zero){
                case 0 : sb.append("E\n"); break;
                case 1 : sb.append("A\n"); break;
                case 2 : sb.append("B\n"); break;
                case 3 : sb.append("C\n"); break;
                case 4 : sb.append("D\n"); break;
            }

        }
        System.out.println(sb);



    }

}
