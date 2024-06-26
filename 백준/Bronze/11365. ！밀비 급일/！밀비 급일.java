import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = br.readLine();
            if(s.equals("END")){
                break;
            }

            char[] temp = s.toCharArray();

            for(int i= temp.length-1;i>=0;i--){
                sb.append(temp[i]);
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }

}