import java.io.*;
import java.util.*;

public class Main {

    public static int[] mbti;
    // E = 0, I = 8
    // S = 0, N = 4
    // T = 0, F = 2
    // J = 0, P = 1
    /*
    01. ESTJ = 0   0000
    02. ESTP = 1   0001
    03. ESFJ = 2   0010
    04. ESFP = 3   0011
    05. ENTJ = 4   0100
    06. ENTP = 5   0101
    07. ENFJ = 6   0110
    08. ENFP = 7   0111
    09. ISTJ = 8   1000
    10. ISTP = 9   1001
    11. ISFJ = 10  1010
    12. ISFP = 11  1011
    13. INTJ = 12  1100
    14. INTP = 13  1101
    15. INFJ = 14  1110
    16. INFP = 15  1111
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            mbti = new int[16];
            st = new StringTokenizer(br.readLine(), " ");
            if(N>32){
                sb.append("0\n");
                continue;
            }
            while (st.hasMoreTokens()) {
                char[] temp = st.nextToken().toCharArray();
                int mbtiNo = 0;
                if (temp[0] == 'I') mbtiNo += 8;
                if (temp[1] == 'N') mbtiNo += 4;
                if (temp[2] == 'F') mbtiNo += 2;
                if (temp[3] == 'P') mbtiNo += 1;
                mbti[mbtiNo]++;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 16; i++) {
                if (mbti[i] == 0) continue;
                mbti[i]--;
                for (int j = 0; j < 16; j++) {
                    if (mbti[j] == 0) continue;
                    mbti[j]--;
                    for (int k = 0; k < 16; k++) {
                        if (mbti[k] == 0) continue;

                        int sumTemp = 0;
                        sumTemp += checkDistance(i, j);
                        sumTemp += checkDistance(i, k);
                        sumTemp += checkDistance(j, k);

                        min = Math.min(min, sumTemp);

                    }
                    mbti[j]++;
                }
                mbti[i]++;
            }
            sb.append(min + "\n");
        }

        System.out.println(sb.toString());

    }

    public static int checkDistance(int a, int b) {
        int distance = 0;

        int temp = a^b;

        if(temp >= 8){
            distance++;
            temp-=8;
        }
        if(temp >=4){
            distance++;
            temp-=4;
        }
        if(temp>=2){
            distance++;
            temp-=2;
        }
        if(temp>=1){
            distance++;
        }

        return distance;
    }
}