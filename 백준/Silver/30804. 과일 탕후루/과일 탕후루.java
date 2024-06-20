import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int[] check = new int[10];
        int start = 0;
        int end = 0;
        int max = 0;

        for(int i=0;i<n;i++){
            check[arr[i]]++;
            if(check[arr[i]] == 1){
                count++;
            }
            end = i;

            if( count >2){
                while(count>2){
                    check[arr[start]]--;
                    if(check[arr[start]] == 0){
                        count--;
                    }
                    start++;
                }
            }

            if(count <= 2){
                max = Math.max(max, end-start +1);
            }

        }

        System.out.println(max);



    }
}
