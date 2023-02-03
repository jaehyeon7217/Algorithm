import java.io.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      
      /*
       * 수 = 0 1 수
       * 
       * 0 = 1 0
       * 1 = 0 1
       * 2 = 1 1 , f(2) = f(1) + f(0)
       * 3 = 1 2 , f(3) = f(2) + f(1)
       * 4 = 2 3 , f(4) = f(3) + f(2)
       * 
       * 
       * 0갯수 1갯수 따로해서 f(n) = f(n-1) + f(n-2)
       * 
       * 메모리 : int 4byte * 82 = 328byte
       * 시간 : O(N)
       * 
       */
      
      int[] oneCount = new int[41];
      int[] zeroCount = new int[41];
      
      zeroCount[0] = 1;
      zeroCount[1] = 0;
      oneCount[0] = 0;
      oneCount[1] = 1; // 피보나치 수열이기 때문에 0과 1은 직접 입력
      
      for(int i=2;i<41;i++) {
         zeroCount[i] = zeroCount[i-1] + zeroCount[i-2];
         oneCount[i] = oneCount[i-1] + oneCount[i-2];
         // 피보나치 계산 (40까지니 싹다 계산)
      }
      
      int T = Integer.parseInt(br.readLine());
      
      for(int t=0; t<T;t++) {
         int N = Integer.parseInt(br.readLine());
         
         sb.append(zeroCount[N] + " "+ oneCount[N] + "\n");
         // 출력
         
      }
      
      bw.write(sb.toString());
      bw.close();
      br.close();
   }

}