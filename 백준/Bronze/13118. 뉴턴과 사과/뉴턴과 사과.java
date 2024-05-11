import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] people = new int[4];
        for(int i=0;i<4;i++){
            people[i] =Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y  = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int result = 0;

        for(int i=0;i<4;i++){
            if(people[i] == x){
                result = i+1;
                break;
            }
        }

        System.out.println(result);


    }


}
