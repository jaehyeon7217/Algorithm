import java.io.*;
import java.util.*;


public class Main {

    public static int answer=0, nowA=0, nowB=0 , n, m, A[], B[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        A = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            A[i]= Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        B = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<m;i++){
            B[i]= Integer.parseInt(st.nextToken());
        }

        while(seek(nowA, nowB)){
        }
        System.out.println(answer);
        System.out.println(sb);

    }

    public static boolean seek(int a, int b){
        int max = 0;
        int pointA = 0;
        int pointB = 0;
        for(int i=a;i<n;i++){
            for(int j=b;j<m;j++){
                if(A[i] == B[j] && max<A[i]){
                    max = A[i];
                    pointA = i;
                    pointB = j;
                }
            }
        }

        if(max == 0){
            return false;
        }
        else{
            sb.append(max + " ");
            answer++;
            nowA = pointA+1;
            nowB = pointB+1;
            return true;
        }

    }
}
