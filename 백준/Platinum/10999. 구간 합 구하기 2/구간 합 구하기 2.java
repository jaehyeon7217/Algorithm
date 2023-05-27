import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, k;
    public static long[] map;
    public static long[] tree;
    public static long[] lazy;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 입력 : n(수의 개수), m(수의 변경이 일어나는 횟수), k(구간의 합을 구하는 횟수)
        // n은 100만, m과 k는 1만씩 => int
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 배열 크기 할당
        // 값의 범위가 -2^63 ~ 2^63-1 이므로 long
        // int는 -2^31 ~ 2^31-1 (-2,147,483,648 ~ 2,147,483,647)
        map = new long[n];
        tree = new long[findSize()];
        // 느린 새그먼트 트리
        lazy = new long[findSize()];

        // n개의 수를 입력받는다.
        for (int i = 0; i < n; i++) {
            map[i] = Long.parseLong(br.readLine());
        }

        // 새그먼트 트리를 만든다.
        init(0, n - 1, 1);
        // 값이 변경되거나 구간 합을 구하는 반복문 시작
        // 최대 2만번
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            // flag는 1 또는 2
            // 1이면 숫자 변경, 2인경우 구간합
            int flag = Integer.parseInt(st.nextToken());
            // start와 end는 최대 100만 => int
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            // 숫자 변경은 인자 3개
            if (flag == 1) {
                // diff는 -2^63 ~ 2^63-1 => long
                long diff = Long.parseLong(st.nextToken());

                // 업데이트는 이분탐색이니 최대 O(log n)
                update(0, n - 1, 1, start, end, diff);
            }
            // 구간합은 인자 2개
            else {
                // 바로 StringBuilder에 담는다.
                sb.append(findValue(0, n - 1, 1, start, end) + "\n");
            }
        }

        // 출력
        System.out.println(sb.toString());

    }

    // 새그먼트 트리 초기 값 만들기
    // start, end는 map 배열 탐색 범위
    // node는 tree의 인덱스
    public static long init(int start, int end, int node) {
        // start와 end가 같아지는 순간은 map의 값을 넣는다.
        if (start == end) {
            return tree[node] = map[start];
        }

        // start와 end의 중간을 찾는다.
        int mid = (start + end) / 2;

        // tree에 양쪽 자식을 연결하고 두 자식의 합을 넣는다.
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    // 새그먼트 트리의 값을 찾는 함수
    // start와 end, node는 위와 같다.
    // x, y는 구간의 시작과 끝이다.
    public static long findValue(int start, int end, int node, int x, int y) {
        // lazy 값이 남은게 있는지 확인
        propagate(start, end, node);
        // 구하고자 하는 범위 밖
        if (end < x || y < start) {
            return 0;
        }
        // 구하고자 하는 범위의 안
        if (x <= start && end <= y) {
            return tree[node];
        }

        // 구하고자 하는 범위의 안과 밖에 걸쳐 있을 때 이분탐색
        int mid = (start + end) / 2;

        return findValue(start, mid, node * 2, x, y) + findValue(mid + 1, end, node * 2 + 1, x, y);

    }

    // 새그먼트 트리의 값을 변경하는 경우
    // start, end, node는 초기함수와 같다.
    // x, y는 변경되어야하는 수의 범위
    // diff는 바뀐 값 - 기존 값으로 차이를 넣어준다.
    public static void update(int start, int end, int node, int x, int y, long diff) {
        // 일단 lazy 있는지 체크
        propagate(start, end, node);

        // index의 위치가 찾고자 하는 범위안에 없으면 종료
        if (y < start || end < x) {
            return;
        }

        // 범위 안에 있다면 값 lazy 걸어줌
        if (x <= start && end <= y) {
            lazy[node] = diff;
            propagate(start, end, node);
            // lazy 를 걸고 하위 부분은 구간합 구할 때 한 번에 갱신
            return;
        }

        // 하위 이분 탐색 시작
        int mid = (start + end) / 2;

        // 이분탐색으로 아래 노드 값을 바꿔주면
        update(start, mid, node * 2, x, y, diff);
        update(mid + 1, end, node * 2 + 1, x, y, diff);
        // 노드값도 바꿔줌
        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }

    public static void propagate(int start, int end, int node) {
        // lazy 처리된 값이 없으면 끝
        if (lazy[node] == 0) return;
        // 리프노드가 아니면 자식에게 lazy를 물려줌
        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        // 트리에 자식의 갯수만큼 변경된 값을 전달.
        // + 1 해주는 이유는 인덱스가 0번부터 시작하기 때문에
        tree[node] += lazy[node] * (end - start + 1);
        // 업데이트 완료
        lazy[node] = 0;
    }

    public static int findSize() {
        // 사이즈는 2의 x승 했을 때 n값 보다 커지는 값의 2배
        int size = 2;
        while (size < n) {
            size *= 2;
        }
        return size * 2;
    }

    // 트리 확인용
    public static void pr() {
        System.out.println();
        for (int i = 0; i < findSize(); i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

}
