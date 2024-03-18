import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            if(name.equals("#")){
                break;
            }
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            boolean flag = true;

            if(age > 17 || weight >= 80){
                flag = false;
            }

            sb.append(name + " " + (flag ? "Junior" : "Senior") + "\n");


        }

        System.out.println(sb.toString());


    }


}