import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, count =0;
    public static int[] truth;
    public static int[] parent;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        st = new StringTokenizer(br.readLine());
        truth = new int[Integer.parseInt(st.nextToken())];

        for(int i=0;i<truth.length;i++){
            truth[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> list = new ArrayList<>();
        for(int M=0;M<m;M++) {
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int[] tempList = new int[size];
            tempList[0] = a;
            for(int i=1;i<size;i++) {
                int temp = Integer.parseInt(st.nextToken());
                tempList[i] = temp;
                union(a, temp);
                a = temp;
            }
            list.add(tempList);
        }

        int size = list.size();
        int truthSize = truth.length;

        for(int i=0;i<size;i++){
            int[] value = list.get(i);
            boolean flag = true;
            int length = value.length;
            bq: for(int j = 0 ; j<length; j++){
                for(int k=0;k<truthSize;k++){
                     if(check(value[j],truth[k])){
                         flag = false;
                         break bq;
                     }
                }
            }

            if(flag) count++;

        }

        System.out.println(count);
    }
    public static void init(){
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static boolean check(int x, int y){
        return find(x) == find(y) ? true: false;
    }


}
