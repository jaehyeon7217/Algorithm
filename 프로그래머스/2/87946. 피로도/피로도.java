class Solution {
    public static int size;
    public static int answer = 0;
    public static boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        
        size = dungeons.length;
        check = new boolean[size];
        
        func(0,k,dungeons);
        
        // System.out.println(size);
        
        
        return answer;
    }
    
    public static void func(int num, int hp, int[][] d){
        if(num == size){
            answer = num;
            return;
        }
        
        for(int i=0;i<size;i++){
            if(check[i]) continue;
            if(hp>= d[i][0]){
                answer = Math.max(answer, num+1);
                check[i] = true;
                func(num+1, hp-d[i][1], d);
                check[i] = false;
            }
        }
        
    }
}