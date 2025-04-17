class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int index = 1;
        int direction = 0;
        int x =0;
        int y =0;
        
        while(index <= n*n){
            answer[x][y] = index;
            index++;
            int nX = x+dx[direction];
            int nY = y+dy[direction];
            if(nX <0 || nX>=n  || nY<0 || nY>=n || answer[nX][nY] != 0){
                direction = (direction+1)%4;
            }
            x += dx[direction];
            y += dy[direction];
        }
        
        return answer;
    }
}