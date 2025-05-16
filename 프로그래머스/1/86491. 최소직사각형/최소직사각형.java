import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        // 정방향 -> 80 70
        // 돌려서 -> 
        
        int x = 0;
        int y = 0;
                
        for(int[] a : sizes){
            if(a[0] < a[1]){
                int temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
            
            x = Math.max(x, a[0]);
            y = Math.max(y, a[1]);
            
        }
        
        int answer = x*y;
        return answer;
    }
    
}