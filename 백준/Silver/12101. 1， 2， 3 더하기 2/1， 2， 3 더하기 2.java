import java.io.*;
import java.util.*;

public class Main {

    public static int n, k, count;
    public static LinkedList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        if(k > dp[n]){
            sb.append("-1");
        }else{
            count = 0;
            list = new LinkedList<>();
            find(n, 0);

            for(int i=0;i<list.size()-1;i++){
                sb.append(list.get(i) + "+");
            }
            sb.append(list.get(list.size()-1));
        }

        System.out.println(sb);

    }

    public static boolean find(int num, int f){
        if(num == 0){
            count++;
            if(count == k){
                return true;
            }
            return false;
        }

        if(num>=1){
            list.add(1);
            if(find(num-1,f+1)){
                return true;
            }
            list.remove(f);
        }
        if(num>=2){
            list.add(2);
            if(find(num-2,f+1)){
                return true;
            }
            list.remove(f);
        }
        if(num>=3){
            list.add(3);
            if(find(num-3,f+1)){
                return true;
            }
            list.remove(f);
        }
        return false;
    }

}
