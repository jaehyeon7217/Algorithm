import java.util.*;
class Solution {
    public Integer[] solution(String[] strlist) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(String s : strlist){
            list.add(s.length());
        }
        
        return list.toArray(new Integer[list.size()]);
    }
}