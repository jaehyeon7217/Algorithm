import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /*
        1번 옮기기 start -> end

        1->3

        2번 옮기기 1번 옮기기 후 1->3 1번 옮기기

        1->2, 1->3, 2->3

        3번 옮기기 2번 옮기기 후 1->3 2번 옮기기

        1->3, 1->2, 3->2, 1->3, 2->1, 2->3, 1->3

        1번에 있는 것을 2번으로 옮긴다.
        1번에 있는 것을 3번으로 옮긴다.
        2번에 있는 것을 3번으로 옮긴다.



         */

        func(n, 1, 2, 3);

        System.out.println((1<<n)-1 );
        System.out.println(sb.toString());


    }

    public static void func(int n, int start, int mid, int end) {
        if (n == 0) {
            return;
        }
        func(n - 1, start, end, mid);
        sb.append(start + " " + end + "\n");
        func(n - 1, mid, start, end);

    }


}