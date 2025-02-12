import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());

            long[] arr = new long[6];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<6;i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
            int count=1;
            while(true){
                long sum= 0;

                for(int i=0;i<6;i++){
                    sum+=arr[i];
                }

                if(sum <=n ){
                    count++;
                    long[] newArr = new long[6];
                    for(int i=0;i<6;i++){
                        newArr[i] = arr[i]+ arr[ (i+1)%6 ] + arr[(i+3)%6] + arr[ i - 1 == -1 ? 5 : i-1];
                    }
                    for(int i=0;i<6;i++){
                        arr[i] = newArr[i];
                    }

                }else{
                    break;
                }
            }

            sb.append(count+"\n");

        }
        System.out.println(sb);

    }



}
