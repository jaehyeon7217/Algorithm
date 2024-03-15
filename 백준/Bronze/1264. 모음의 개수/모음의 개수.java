import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals("#")) {
                break;
            }
            s = s.toLowerCase();
            char[] c = s.toCharArray();
            int count = 0;
            for (int i = 0; i < c.length; i++) {
                if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u'){
                    count++;
                }
            }

            sb.append(count+"\n");

        }

        System.out.println(sb.toString());


    }

}