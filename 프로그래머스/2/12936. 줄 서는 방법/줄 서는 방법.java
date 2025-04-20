import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        /*
        1
        1
        
        2
        12
        21
        
        3
        123
        132
        213
        231
        312
        321
        
        4
        1234
        1243
        1324
        1342
        1423
        1432
        
        5
        12345
        12354
        12435
        12453
        12534
        12543
        13245
        13254
        13
        
        
        */
        
//         long[] num = new long[21];
        
//         num[1] = 1l;
//         for(int i=2;i<21;i++){
//             num[i] = i*num[i-1];
//         }
        
        // size = n;
        // n1 = new boolean[size];
        // a = new int[size];
        
        
        // dfs(0);
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        
        long[] num = new long[n+1];
        num[0] = 1l;
        num[1] = 1l;
        for(int i=2; i<=n;i++){
            num[i] = i*num[i-1];
        }
        int[] answer = {};
        
        answer = new int[n];
        int count = 0;
        
        while(!list.isEmpty()){
            int size = list.size();
            long temp = (k-1)/num[size-1];
            answer[count++] = list.remove((int)temp);
            k -= temp*num[size-1];
        }
        
        
        // System.out.println(num[n]);
        
        
        return answer;
    }
//     public static int size = 0;
//     public static boolean[] n1;
//     public static int[] a;
    
//     public static void dfs(int num){
//         if( num== size){
//             for(int i=0;i<size;i++){
//                 System.out.print(a[i] + " ");
//             }
//             System.out.println();
//             return;
//         }
//         for(int i=0;i<size;i++){
//             if(n1[i]) continue;
//             n1[i] = true;
//             a[num] = i+1;
//             dfs(num+1);
//             n1[i] = false;
//         }
//     }
}