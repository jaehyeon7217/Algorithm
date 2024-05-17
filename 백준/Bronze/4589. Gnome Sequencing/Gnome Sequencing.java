import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        sb.append("Gnomes:\n");

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            boolean isMinus = false;

            boolean isOrder = false;

            if(a-b<0) isMinus = true;

            if(b-c<0){
                if(isMinus){
                    isOrder = true;
                }
            }else{
                if(!isMinus){
                    isOrder = true;
                }
            }
            sb.append(isOrder ? "Ordered\n" : "Unordered\n");

        }

        System.out.println(sb);


    }


}
