import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {/// t번 만큼 반복 시작
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int gap = e - s;

            if (gap <= 2) {
                sb.append(gap + "\n");
            } else {
                long now = 3;
                int value = 3;
                int loop = 2;
                boolean flag = true;
                while (true) {
                    if (gap < now + loop) {
                        sb.append(value + "\n");
                        break;
                    }
                    if (flag) {
                        now += loop;
                        value++;
                        flag = false;
                    } else {
                        now += loop;
                        value++;
                        loop++;
                        flag = true;
                    }
                }
            }

        }// t번 만큼 반복 끝

        System.out.println(sb.toString());


    }
}