class Solution {
    public int solution(int angle) {
        int answer = angle/90;      
        return angle > 90 ? answer + 2 : answer + 1 ;
    }
}