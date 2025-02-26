import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][2];

        // arr[1] => 1번 항목
        // [0] => 몇 번 만에 왔는지 count
        // [1] => 이전 항목이 뭔지 저장
        // ex)
        // arr[1][0] = 1
        // arr[1][1] = 3
        // 1번만에 1까지 왔고 그전은 3이다.


        q = new LinkedList<>();

        arr[n][1] = -1;

        q.offer(n);

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (temp == 1) {
                break;
            }

            // 3으로 나누어지고 방문 횟수가 적을 때나 방문한 적이 없을 때
            func(temp, 3);
            // 2
            func(temp, 2);
            // 아니면 1 빼기
            if (arr[temp - 1][0] > arr[temp][0] + 1 || arr[temp - 1][0] == 0) {
                arr[temp - 1][0] = arr[temp][0] + 1;
                arr[temp - 1][1] = temp;

                q.offer(temp - 1);
            }
        }

        sb.append(arr[1][0] + "\n");

        ArrayList<Integer> list = new ArrayList<>();

        int i = 1;

        while(i!=-1){
            list.add(i);
            i = arr[i][1];
        }

        for(i=list.size()-1; i>=0;i--){
            sb.append(list.get(i)+" ");
        }

        System.out.println(sb);

    }

    public static void func(int n, int flag) {
        if (n % flag == 0 && (arr[n / flag][0] > arr[n][0] + 1 || arr[n / flag][0] == 0)) {
            arr[n / flag][0] = arr[n][0] + 1;
            arr[n / flag][1] = n;

            q.offer(n / flag);
        }
    }


}