import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for(String s : s1){
            answer += Arrays.stream(s2)
                .filter((ss) -> s.equals(ss))
                .count();
        }
        return answer;
    }
}