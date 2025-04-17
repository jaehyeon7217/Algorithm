import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String s : babbling){
            boolean check = true;
            boolean[] count = new boolean[4];
            for(int i = 0; i<s.length() ;){
                char c = s.charAt(i);
                
                if(c == 'a' && i+2<s.length() && s.charAt(i+1) == 'y' && s.charAt(i+2) == 'a' && !count[0]){
                    i+=3;
                    count[0] = true;
                }else if(c == 'y' && i+1<s.length() && s.charAt(i+1) == 'e' && !count[1]){
                    i+=2;
                    count[1] = true;
                }else if(c == 'w' && i+2<s.length() && s.charAt(i+1) == 'o' && s.charAt(i+2) == 'o'&& !count[2] ){
                    i+=3;
                    count[2] = true;
                }else if(c == 'm' && i+1<s.length() && s.charAt(i+1) == 'a' && !count[3]){
                    i+=2;
                    count[3] =true;
                }else{
                    check = false;
                    break;
                }
                
            }
            
            if(check){
                answer++;
            }
            
            
        }
        
        
        return answer;
    }
}