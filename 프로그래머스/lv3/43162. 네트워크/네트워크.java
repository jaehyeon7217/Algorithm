import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int[] parent = init(n);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(computers[i][j] == 1){
                    parent = union(parent,i,j);
                }
            }
        }
        

        for(int i=0;i<n;i++){
            if(parent[i] == i) answer++;
        }
      
        return answer;
    }
    
    public static int[] init(int n){
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = i;
        }
        return temp;
        
    }
    
    public static int find(int[] parent, int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
    
    public static int[] union(int[] parent, int x, int y){
        x = find(parent,x);
        y = find(parent,y);
        
        if(x==y)return parent;
        
        if(x<y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
        
        return parent;
        
    }
    
}