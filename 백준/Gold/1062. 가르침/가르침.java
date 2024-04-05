import java.io.*;
import java.util.*;

public class Main {
    public static int n, k, max = 0;
    public static boolean[] word = new boolean[26];
    public static char[][] s;
    public static boolean[] pickWord = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        s = new char[n][];


        for (int i = 0; i < n; i++) {
            s[i] = br.readLine().toCharArray();

            for (int j = 0; j < s[i].length; j++) {
                int temp = s[i][j] - 'a';
                word[temp] = true;
            }

        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (word[i]) count++;
        }

        if (count < 5) {
            System.out.println(0);
            System.exit(0);
        }
        if (count < k) {
            System.out.println(n);
            System.exit(0);
        }

        pickWord['a' - 'a'] = true;
        pickWord['n' - 'a'] = true;
        pickWord['t' - 'a'] = true;
        pickWord['i' - 'a'] = true;
        pickWord['c' - 'a'] = true;

        pick(5, 0);

        System.out.println(max);
    }

    public static void pick(int step, int start) {
        if (step == k) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < s[i].length; j++) {
                    if (!pickWord[s[i][j] - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }


        for(int i=start; i<26;i++){
            if(!word[i]) continue;
            if(pickWord[i]) continue;
            pickWord[i] = true;
            pick(step+1, i+1);
            pickWord[i]= false;
        }


    }


}