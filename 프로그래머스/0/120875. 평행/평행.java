import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        // 두 직선이 평행 == 기울기가 같다.
        // 기울기 == y증가량/x증가량
        // (y2-y1)/(x2-x1)
        // 경우의 수
        // 01/23, 02/13, 03/12
        
        
        
        int answer = calc(dots[0], dots[1], dots[2], dots[3]) ? 1 : 0;
        if(answer == 0 ){
            answer = calc(dots[0], dots[2], dots[1], dots[3]) ? 1 : 0;
        }
        if(answer == 0 ){
            answer = calc(dots[0], dots[3], dots[1], dots[2]) ? 1 : 0;
        }
        
        return answer;
    }
    
    public static boolean calc(int[] x1, int[] x2, int[] x3, int[] x4){
        double x = (double)(x2[1]-x1[1]) / (x2[0]-x1[0]);
        double y = (double)(x4[1]-x3[1]) / (x4[0]-x3[0]);
        
        return x==y? true : false; 
    }
    
    
}