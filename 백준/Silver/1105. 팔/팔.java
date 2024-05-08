import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        char[] l = st.nextToken().toCharArray();
        char[] r = st.nextToken().toCharArray();

        if(l.length != r.length) System.out.println(0);
        else{
            int count = 0;
            for(int i=0;i<l.length;i++){
                if(l[i] != r[i]) break;
                if(l[i] == '8') count++;
            }
            System.out.println(count);
        }





    }

}
