import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] dp = new int[a.length+1][b.length+1];

        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                dp[i][j] = a[i-1] == b[j-1] ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        List<Integer> list = new ArrayList<>();
        int j=b.length;
        for(int i=a.length; i>0;i--){
            if(dp[i][j] == dp[i-1][j]) continue;
            while(dp[i][j] == dp[i][j-1]){
                j--;
            }
            list.add(i);
            j--;
        }


        System.out.println(list.size());

        if(list.size()!= 0){
            StringBuilder sb =new StringBuilder();
            for(int i=list.size()-1;i>=0;i--){
                sb.append(a[list.get(i)-1]);
            }
            System.out.println(sb);
        }

    }

}
