import java.io.*;
import java.util.*;

public class Main {

    public static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n > 1023) {
            System.out.println("-1");
            System.exit(0);
        }
        if (n <= 10) {
            System.out.println(n - 1);
            System.exit(0);
        }
        if (n == 1023) {
            System.out.println("9876543210");
            System.exit(0);
        }

        int[][] map = new int[10][10];

        for (int i = 0; i < 10; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                map[i][j] = map[i][j - 1] + map[i - 1][j - 1];

            }
        }

        int[][] dp = new int[10][10];
        int temp = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 0) continue;

                dp[i][j] = temp + map[i][j];
                temp = dp[i][j];

            }
        }
        int num = 0; // 앞자리 수 x축(j)
        int count = 0; // 0의 갯수 y축(i)
        int gap = 0;
        char[] ans;

        bp : for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (dp[i][j] == 0) continue;
                if (n > dp[i][j]) continue;

                num = j;
                count = i;
                gap = dp[i][j] - n;

                break bp;
            }
        }

        answer = new int[count+1];
        answer[0] = num;

        find(num-1,count-1, 1, gap);


        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]);
        }


    }

    public static int sum = 0;
    public static boolean find(int num, int count, int set, int gap){

        if(count==0){
            for(int i=num;i>=0;i--){
                if(sum==gap){
                    answer[set] = i;
                    return true;
                }
                sum++;
            }

            return false;
        }

        for(int i=num; i>=0;i--){
            answer[set] = i;
            if(find(i-1,count-1,set+1,gap)){
                return true;
            }
        }

        return false;

    }


}