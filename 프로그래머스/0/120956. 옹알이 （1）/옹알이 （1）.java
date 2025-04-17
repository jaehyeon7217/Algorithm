import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String s : babbling){
            for(int i=0;i<4;i++){
                if(s.contains(words[i])){
                    s=s.replace(words[i], "1");
                }
            }
            s = s.replaceAll("1", "");
            if(s.isEmpty()){
                answer++;
            }
        }
        
        
        return answer;
    }
}