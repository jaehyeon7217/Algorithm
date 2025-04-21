import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = (int)IntStream.rangeClosed(1, n)
            .filter((i) -> n%i == 0 ? true : false)
            .count();
        
        return answer;
    }
}