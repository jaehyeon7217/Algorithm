import java.io.*;
import java.util.*;


public class Main {

    public static int[] compareNum = new int[31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        compareNum[1] = 2;

        for (int i = 2; i <= 30; i++) {
            compareNum[i] = compareNum[i - 1] * 2;
        }

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[30];

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());

            arr[count(num[i])]++;

        }

        int center = (n + 1) / 2;
        int countCheck = 0;
        int sum = 0;

        for (int i = 0; i < 30; i++) {
            if(countCheck + arr[i] > center){
                int temp = center - countCheck;
                sum += i*temp;
                break;
            }
            countCheck+=arr[i];
            sum += i*arr[i];
            if(countCheck == center) break;
        }

        System.out.println(sum +1);


    }

    public static int count(int num) {
        int ans = 0;
        for (int i = 1; i < 31; i++) {
            if (compareNum[i] > num) {
                ans = i - 1;
                break;
            }
        }
        return ans;

    }


}
