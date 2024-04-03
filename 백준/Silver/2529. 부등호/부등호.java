import java.io.*;
import java.util.*;

public class Main {

    public static int k;
    public static char[] op;
    public static boolean[] num = new boolean[10];
    public static int[] answer;
    public static long min = 10000000000l, max = 0;
    public static String ansMin, ansMax;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        k = Integer.parseInt(br.readLine());
        op = new char[k];
        answer = new int[k+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<k;i++){
            op[i] = st.nextToken().charAt(0);
        }

        for(int i=0;i<10;i++){
            answer[0] = i;
            num[i]= true;
            solve(1);
            num[i]=false;
        }

        System.out.println(ansMax);
        System.out.println(ansMin);

    }

    public static void solve(int step){
        if(step == k+1){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<k+1;i++){
                sb.append(answer[i]);
            }
            long temp = Long.parseLong(sb.toString());

            if(min > temp){
                min = temp;
                ansMin = sb.toString();
            }
            if(max<temp){
                max = temp;
                ansMax = sb.toString();
            }
            return;
        }

        for(int i=0;i<10;i++){
            if(num[i]) continue;
            if((op[step-1] == '<' && answer[step-1] < i) || (op[step-1] == '>' && answer[step-1] > i)){
                answer[step] = i;
                num[i] = true;
                solve(step+1);
                num[i] = false;
            }
        }



    }



}