import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] top = new int[h+1];
        int[] bottom = new int[h+1];

        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());

            if(i%2 == 0){
                bottom[a]++;
            }else{
                top[a]++;
            }
        }


        for(int i=h;i>1;i--){
            top[i-1] += top[i];
            bottom[i-1] += bottom[i];
        }

        int min = n/2;
        int count = 2;

        for(int i=1;i<h-1;i++){
            int temp = 0;
            temp = bottom[i+1]+top[h-i];

            if(min>temp){
                min = temp;
                count = 1;
            }else if(min == temp){
                count++;
            }
        }

        System.out.println(min + " " + count);

    }

}
