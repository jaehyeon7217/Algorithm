import java.io.*;
import java.util.*;

public class Main {

   public static int N, count = 0;
   public static char[][] board;
   public static Queue<XY> q = new LinkedList<>();
   public static boolean[][] visit;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      
      /*
       * BFS를 두 번 돌려서 R과 G를 따로 계산, R과 G를 하나로 계산 해서 출력
       * 
       * 최대 100*100 = 10,000 -> 입력, BFS 계산 *2
       * BFS 최악의 경우도 10,000 * 4 *2 = 80,000 
       * 대략 20,000 + 80,000 = 100,0000 ?? 정도?
       * 
       */
      
      N = Integer.parseInt(br.readLine());
      board = new char[N][N];
      
      for(int i=0;i<N;i++) {
         board[i] = br.readLine().toCharArray();
      }
      
      visit = new boolean[N][N];
      
      for(int i = 0; i< N ; i++) {
         for(int j=0; j< N; j++) {
            
            if(!visit[i][j]) {
               char temp = 'N';
            
               // board 값이 RGB 이면 temp에 값을 입력
               
               if(board[i][j] == 'R') {
                  temp = 'R';
               }
               
               if(board[i][j] == 'G') {
                  temp = 'G';
               }
                     
               if(board[i][j] == 'B') {
                  temp = 'B';
               }
               
               // temp가 초기값이 아닐 때 bfs 돌리기
               if(temp != 'N') {
                  q.offer(new XY(i,j));
                  visit[i][j] = true;
                  bfs(temp);
                  count++;
                  
                  // 이때 구역별 수니까 BFS를 돌리면 1구역은 모두 visit == true;
                  // 그래서 count++;해주면 구역 갯수 +1
               }
            }
            
         }
      }
      sb.append(count + " ");
      visit = new boolean[N][N];
      count = 0;
      // 찍어주고 visit와 count 초기화
      
      // RG가 같은 색으로 취급해서 BFS 탐색
      for(int i = 0; i< N ; i++) {
         for(int j=0; j<N; j++) {
            
            if(!visit[i][j]) {
               char temp = 'N';
            
               // 이때 R, G를 같은 것으로 봐야하니 RG가 오면 S를 넘겨줌
               if(board[i][j] == 'R' || board[i][j] == 'G') {
                  temp = 'S';
               }
                                    
               if(board[i][j] == 'B') {
                  temp = 'B';
               }
               
               if(temp != 'N') {
                  q.offer(new XY(i,j));
                  visit[i][j] = true;
                  bfs(temp);
                  count++;
               }
            }
            
         }
      }
      sb.append(count + "\n");
      
      bw.write(sb.toString());
      bw.close();
      br.close();
      
   }
   
   public static int[] dx = {1,-1,0,0};
   public static int[] dy = {0,0,1,-1};
   
   public static void bfs(char target) {
      
      boolean flag = false;
      if(target == 'S') flag = true;
      // S로 오면 플래그 활성화
      
      while(!q.isEmpty()) {
         XY temp = q.poll();
         
         for(int i=0;i<4;i++) {
            int x = temp.x + dx[i];
            int y = temp.y + dy[i];
            
            if(x<0 || x>=N || y<0 || y>= N) continue;
            if(visit[x][y]) continue;
            
            if(flag) {// S가 오면 R, G를 같은 취급 둘다 visit == true
               if(board[x][y] == 'R' || board[x][y] == 'G') {
                  visit[x][y] = true;
                  q.offer(new XY(x,y));
               }
            }
            else {// 아닐 땐 각자 visit 체크
               if(board[x][y] == target) {
                  visit[x][y] = true;
                  q.offer(new XY(x,y));
               }
            }
         
         }
      }
      
   }
   
   public static class XY{
      int x;
      int y;
      XY(int x, int y){
         this.x = x;
         this.y = y;
      }
   }
   
}