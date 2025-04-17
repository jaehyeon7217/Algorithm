import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
         
        return (int)Arrays.stream(array)
                .filter((x) -> x == n)
                .count();
    }
}