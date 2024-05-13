import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, k;
    public static int[] child, arr, countChild, countCost;
    public static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        child = new int[n];
        arr = new int[n];
        countChild = new int[n];
        countCost = new int[n];
        result = new int[k];

        for(int i=0;i<n;i++){
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            child[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(a,b);
        }

        for(int i=0;i<n;i++){
            find(i);
            countChild[arr[i]]++;
            countCost[arr[i]] += child[i];
        }

        for(int i=0;i<n;i++){
            if(countChild[i] == 0) continue;
            if(countChild[i]>=k) continue;
            boolean[] check = new boolean[k];

            for(int j=k-1; j>=countChild[i]; j-- ){
                if(check[j-countChild[i]]) continue;
                if(result[j] < result[j-countChild[i]]+countCost[i]){
                    check[j] = true;
                    result[j] = result[j-countChild[i]] + countCost[i];
                }
            }

        }

        System.out.println(result[k-1]);

    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a<b){
            arr[b] = a;
        }else{
            arr[a] = b;
        }
    }

    public static int find(int a){
        if(arr[a] == a){
            return a;
        } else{
            return arr[a] = find(arr[a]);
        }
    }



}
