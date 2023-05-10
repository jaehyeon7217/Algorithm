import java.io.*;
import java.util.*;

public class Main {

    public static int[] parent;
    public static int[] weight;
    public static int n,m;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());

            n= Integer.parseInt(st.nextToken());
            m= Integer.parseInt(st.nextToken());
            if(n==0 && m==0) break;

            init();

            for(int M=0;M<m;M++){
                st= new StringTokenizer(br.readLine());

                char flag = st.nextToken().charAt(0);
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());


                if(flag == '!'){
                    int weight = Integer.parseInt(st.nextToken());
                    union(start,end,weight);
                }
                if(flag=='?'){
                    // 비교할 때 무조건 check를 때리는데 여기서 find로 필요한 weight 값은 다 최신화됨
                    if(!check(start,end)){
                        sb.append("UNKNOWN\n");
                        continue;
                    }
                    sb.append((weight[end] - weight[start])+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void init(){
        parent=new int[n+1];
        weight=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        int rootX = find(parent[x]);
        weight[x] += weight[parent[x]];

        return parent[x]=rootX;
    }

    public static void union(int x, int y, int w){
        int rootX = find(x);
        int rootY = find(y);

        // 무게가 무조건 앞이 작은거라 rootX와 rootY는 비교하지 않는다. (기준이 있음)
        if(rootX!=rootY){
            parent[rootY]=rootX;
            // index :  1 2 3 4 5 6
            // weight : 0 1 2 0 2 4
            // parent : 1 1 1 4 4 4

            // union 2 6 5
            // index(6) - index(2) = 5
            // index(4) - index(2) = 5 - index(6)
            // index(4) = 5 - index(6) + index(2)

            weight[rootY]= w - weight[y] + weight[x];
        }

    }

    public static boolean check(int x, int y){
        if(find(x) == find(y)) return true;
        return false;
    }

}
