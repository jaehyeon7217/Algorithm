import java.io.*;
import java.util.*;

public class Main {

    public static int[] parent;
    public static int n, m;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init(n);

        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

           if(flag == 0){
               union(a,b);
           }else if(flag==1){
               boolean answer = isEqual(a,b);
               sb.append(answer == true ? "YES\n" : "NO\n");
           }
        }

        System.out.println(sb.toString());


    }

    public static void init(int n){
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
    }
    public static int find(int x){
        // 부모가 자기 자신이라면 최상단노드이므로 반환
        if(x==parent[x]){
            return x;
        }
        else{
            // 부모와 자기 자신이 다르다면 최상단 노드를 찾아가자.
            // 근데 이때 최 상단노드를 값으로 저장하자
            return parent[x]=find(parent[x]);
        }
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x<y){
            parent[y]=x;
        }else{
            parent[x]=y;
        }
    }

    public static boolean isEqual(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y) return true;
        else return false;
    }

    public static void pr(){
        for(int i=1;i<=n;i++){
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
