import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=1;i<=t;i++){
            st = new StringTokenizer(br.readLine());
            sb.append("Case #"+i+": "+ (Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())) + "\n");
        }

        System.out.println(sb.toString());
    }

}
