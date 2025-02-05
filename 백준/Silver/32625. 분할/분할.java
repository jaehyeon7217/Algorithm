import java.io.*;
import java.util.*;

public class Main {

    public static int n, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        for(int i=1;i<=n/2;i++){
            if(n%i != 0) continue;

            flag = check(i);
            if(flag){
                break;
            }
        }

        System.out.println(flag ? "1" : "0" );


    }

    public static boolean check(int width){
        int pt = sum(0,width);
        for(int i=width;i<n;i+=width){
            if(pt != sum(i,width)){
                return false;
            }
        }
        return true;
    }

    public static int sum(int start, int width){
        int max = 0;
        int min = 1_234_567_890;
        for(int i=start; i<start+width; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max+min;
    }



}
