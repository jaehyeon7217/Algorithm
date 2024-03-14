import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int now = (hour * 3600) + (minute * 60) + second;

        int time = Integer.parseInt(br.readLine());

        now += time;

        now = (now % 86400);

        int answerH = (now/3600);
        now = now - (answerH * 3600);
        int answerM = (now/60);
        now = now - (answerM * 60);
        System.out.println(answerH + " " + answerM + " " + now);
    }
}