import java.io.*;
import java.util.*;

public class Main {

    public static int n,m,k;
    public static int[] kids, friend;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n은 거리에 있는 아이들의 수,
        // m은 아이들의 친구 관계 수,
        // k는 울음소리가 공명하기 위한 최소 아이의 수이다.
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 아이들이 받은 사탕의 수
        kids = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            kids[i] = Integer.parseInt(st.nextToken());
        }

        // 친구관계 받기

            // Union-Find 알고리즘을 위한 셋팅
        friend = new int[n];
        for(int i=0;i<n;i++){
            friend[i] = i;
        }
            // Union 적용
            // 무리를 지음
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken())-1;
            int two = Integer.parseInt(st.nextToken())-1;

            union(one, two);
        }


        // 무리에 가입된 아이의 수와 그 무리의 사탕 수
        int[] countKids = new int[n];
        int[] sumKids = new int[n];
        for(int i=0;i<n;i++){
            find(i);

            countKids[friend[i]]++;
            sumKids[friend[i]] += kids[i];
        }


        // 무리의 수가 0이 아니라면 한 무리
        // 무리수와 사탕수를 추출
        LinkedList<node> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(countKids[i] == 0) continue;
            list.add(new node(countKids[i], sumKids[i]));
        }

        // Knapsack
        int size = list.size();
        int[][] dp = new int[size+1][k];
        for(int i=1;i<size+1;i++){
            node temp = list.poll();
            for(int j=0;j<k;j++){
                if(j<temp.count){
                    dp[i][j] =dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-temp.count] + temp.cost);
                }
            }
        }


        System.out.println(dp[size][k-1]);

    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a<b){
            friend[b] = a;
        }else{
            friend[a] = b;
        }
    }
    public static int find(int a){
        if(friend[a] == a){
            return a;
        }

        return friend[a] = find(friend[a]);
    }

    public static class node{
        int count;
        int cost;

        public node(int count, int cost){
            this.count = count;
            this.cost = cost;
        }
    }


}
