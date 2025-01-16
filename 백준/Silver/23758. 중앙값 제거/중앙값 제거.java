import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int[] num = new int[n];

        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int center = (n+1)/2;

        int count = 0;

        for(int i=0;i<center;i++){
            count+= count(num[i]);
        }

        System.out.println(count+1);



    }

    public static int count(int num){
        int count = 0;

        while(num != 1){
            num/=2;
            count++;
        }
        return count;
    }


}
