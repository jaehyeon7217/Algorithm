import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static final long INF = Long.MAX_VALUE;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long sum = INF;
        int min = 0;
        int max = n-1;

        int pt1 = 0;
        int pt2 = n-1;
        while(pt1<pt2){
//            System.out.println("now pt1 = " + pt1 + ", pt2 = " + pt2 );
            long tempSum = abs(pt1,pt2);
            if(tempSum == 0){
                min = pt1;
                max = pt2;
                break;
            }

            if(sum> tempSum){
                sum = tempSum;
                min = pt1;
                max = pt2;
            }

//            System.out.println("1 = " + abs(pt1+1,pt2) + ", 2 = " + abs(pt1,pt2-1));

            if(abs(pt1+1,pt2) <= abs(pt1,pt2-1)){
                pt1+=1;
            }else{
                pt2-=1;
            }

        }

        System.out.println(arr[min] + " " + arr[max]);



    }

    public static long abs (int a, int b){
        return Math.abs((long)arr[a] + (long)arr[b]);
    }


}
