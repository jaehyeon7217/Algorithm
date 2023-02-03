import java.io.*;
import java.util.*;

public class Main {

   public static char[][] board = new char[12][6];
   public static int[] dx = {1,-1,0,0};
   public static int[] dy = {0,0,1,-1};
   public static int[] rgbpy = new int[5];
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      /*
       * 배열의 크기가 12*6이라 1번 탐색 시 72
       * 
       * BFS를 2번 돌립니다.
       * 1번째 BFS는 인접한 해당 필드가 4개이상인지 체크,
       * 2번째 BFS는 4개 이상이라면 폭파
       */
      
      for(int i=0;i<12;i++) {
         board[i] = br.readLine().toCharArray();
      }
      
      boolean flag = true;
      int count = 0;
      
      
      while(flag) {
         flag = false;
         for(int i=0; i<12; i++) {
            for(int j=0; j<6 ;j++) {
               if(board[i][j] != '.') {
                  
                  // flag가 1번 true ( 폭파 했음 )이 되면 가지고 갑니다.
                  if(!flag) {         
                     // check는 인접 필드가 4개 이상인지, 4개 이상이면 폭파하는
                     // 2개의 BFS를 실행하는 함수
                     flag = check(i,j,board[i][j]);
                  }
                  else{
                     // ture가 이미 찍혔다면 값은 필요없고 함수만 실행
                     check(i,j,board[i][j]);
                  }
               }
            }
         }
         // true(폭파 한 적이 있음 이라면 연쇄count ++;
         if(flag) {
            count++;
         }
         // 공중에 떠있는 필드들을 바닥까지 내림
         move();
      }
      
      System.out.println(count);
      
   }
   
   public static void move() {
      for(int i=10; i>=0; i--) {
         for(int j=0;j<6;j++) {
            if(board[i][j] != '.') {// board[i][j]가 빈공간이 아니고
               int temp = i;   
            
               while(board[temp+1][j] == '.') { // 아래가 빈공간이면
                  board[temp+1][j] = board[temp][j];
                  board[temp][j] = '.'; // 1칸 추락 후
                  
                   if( temp + 2 <12) { // 바닥인지 아닌지 확인해서
                      temp = temp +1; // 바닥이 아니면 반복
                   }
                   else break;
               }
            }
         }
      }
   }
   
   public static boolean check (int a, int b, char target) {
      Queue<XY> q = new LinkedList<>();
      q.offer(new XY(a,b));
      board[a][b] = 'T'; // bfs를 이용해 visit대신 T값으로 바꿔줌
      
      int count = 1;
      while(!q.isEmpty()) {
         XY temp = q.poll();
         
         for(int i=0;i<4; i++) {
            int x = temp.x + dx[i];
            int y = temp.y + dy[i];
            
            if(x<0 || x>=12 || y<0 || y>=6) continue;
            
            if(board[x][y] == target) { // 같은 필드면 T로 바꿔주고
               count++; // 몇개인지 카운트
               q.offer(new XY (x,y)); 
               board[x][y] = 'T';
            }
         }
      }
      char c;
      boolean flag = false;
      if(count >= 4) { // 4개 이상이면 없애주고 트루
         c = '.';
         flag = true;
      }
      else { //  4개 미만이면 원래대로 
         c = target;
      }
      
      q.offer(new XY(a,b));
      board[a][b] = c;
      
      while(!q.isEmpty()) { // 되돌리는 BFS
         XY temp = q.poll();
         
         for(int i=0;i<4; i++) {
            int x = temp.x + dx[i];
            int y = temp.y + dy[i];
            
            if(x<0 || x>=12 || y<0 || y>=6) continue;
            
            if(board[x][y] == 'T') {
               count++;
               q.offer(new XY (x,y));
               board[x][y] = c;
            }
         }
      }
      
      return flag; // 폭파 여부 반
      
   }

   public static class XY{
      int x;
      int y;
      XY(int x, int y){
         this.x = x;
         this.y = y;
      }
   }
   
   public static void view() {
      for(int i=0;i<12;i++) {
         for(int j=0;j<6;j++) {
            System.out.print(board[i][j]);
         }
         System.out.println("");
      }
   }

}