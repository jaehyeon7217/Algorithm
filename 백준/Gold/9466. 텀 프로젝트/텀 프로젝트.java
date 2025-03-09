import java.util.*;
import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);
    public static StringBuilder sb = new StringBuilder();

    public static int n, arr[];
    public static boolean[] visit, cycle;

    public static void main(String[] args) throws Exception {
        int T = nextInt();

        while(T-- > 0){
            n = nextInt();
            arr = new int[n];
            cycle = new boolean[n];
            visit = new boolean[n];
            int count = 0;


            for(int i=0;i<n;i++){
                arr[i] = nextInt()-1;
                if(arr[i]==i){
                    cycle[i] = true;
                    count++;
                }
            }

            for(int i=0;i<n;i++){
                if(cycle[i]) continue;
                Stack<Integer> stack = new Stack<>();

                int temp = i;
                int intFlag = -1;
                boolean flag = false;

                while(true){
                    visit[temp] = true; // 방문 체크
                    stack.push(temp); // 스택에 넣는다.

                    if(cycle[arr[temp]]) {
                        intFlag = temp;
                        break; // 이미 사이클 있으면 실패
                    }
                    if(visit[arr[temp]]) { // 방문했다 == cycle 이 됐다.
                        flag = true;
                        intFlag = arr[temp];
                        break;
                    }

                    // 다음으로 간다.
                    temp = arr[temp];

                }


                // 형성이 됐다.
                 while(!stack.isEmpty()){
                     int tp = stack.pop();

                     cycle[tp] = true;

                     if(flag){
                         count++;
                     }
                     if(tp == intFlag){
                         flag = false;
                     }


                 }


            }

            sb.append((n-count)+"\n");
        }
        System.out.println(sb);
    }


    public static int nextInt() throws Exception {
        st.nextToken();
        return (int)st.nval;
    }

    public static String next() throws Exception {
        st.nextToken();
        return st.sval;
    }

}
