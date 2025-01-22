import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0; // 연산 횟수
        boolean flag = true; // while문 컨트롤용 boolean 함수

        while (flag) {
            flag = false; // 만약 잘못된 곳이 없다면 false로 탈출
            for (int i = 1; i < n - 1; i++) {

                if (arr[i] * 2 > arr[i - 1] + arr[i + 1]) { // 볼록 구간이 아니라면

                    int temp = arr[i] - (arr[i - 1] + arr[i + 1]) /2; // 차이를 계산

                    count += temp; // 차이만큼 낮아져야하니 카운트에 합산
                    arr[i] -= temp; // 차이만큼 빼서 숫자 맞춰줌

                    flag = true; // 변화가 발생했으니 다시 반복문을 돌라는 뜻
                }
            }
        }
        System.out.println(count); // 출력
    }
}
