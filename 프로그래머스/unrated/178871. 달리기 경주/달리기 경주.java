import java.util.*;
import java.io.*;

class Solution {
    
    public static String[] answer;
    
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap();
        
        answer = players;
        
        for(int i=0;i<players.length;i++)
            map.put(players[i], i);
        
        for(String calling : callings){
            int temp = map.get(calling);
            swap(temp);
            map.put(answer[temp], temp);
            map.put(calling, temp-1);
        }
        
        return answer;
    }
    
    public static void swap(int a){
        String temp = answer[a];
        answer[a] = answer[a-1];
        answer[a-1]=temp;
    }
    
}