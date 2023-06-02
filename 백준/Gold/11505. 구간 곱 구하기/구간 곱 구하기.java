import java.io.*;
import java.util.*;

public class Main {

    public static int n,m,k;
    public static final int num = 1000000007;

    public static int[] map;
    public static long[] tree;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n];
        int size = findSize();
        tree = new long[size];

        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        init(0,n-1,1);

        for(int i=0;i<m+k;i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            if(op == 1){
                update(0,n-1, 1, start, end+1);

            }else{
                sb.append(findValue(0,n-1,1,start,end) + "\n");
            }
        }

        System.out.println(sb);

    }

    public static int findSize(){
        int size = 2;
        while(size<n){
            size*=2;
        }
        return size*2;
    }

    public static long init(int start, int end, int node){
        if(start==end) {
            return tree[node] = map[start];
        }
        int mid = (start+end)/2;
        return tree[node] = (init(start,mid, node*2) * init(mid+1,end, node*2+1))%num;
    }

    public static void update(int start, int end, int node, int index, int value){
        if(index<start || end< index) return;
        if(start == end && start == index ) {
            tree[node] = map[start] = value;
            return;
        }
        int mid = (start + end)/2;

        update(start, mid, node*2, index, value);
        update(mid+1,end,node*2+1, index, value);

        tree[node] = (tree[node*2] * tree[node*2+1])%num;

    }

    public static long findValue(int start, int end, int node, int x, int y){
        if(y<start || end<x) return 1;
        if(x<=start && end<=y) return tree[node];

        int mid= (start + end) /2;

        return (findValue(start, mid, node*2, x, y) * findValue(mid+1, end, node*2+1,x,y))%num;
    }

    public static void pr(){
        System.out.println();
        for(int i=0;i<findSize();i++){
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

}
