import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 
		StringTokenizer st;
		
			st = new StringTokenizer(br.readLine()," "); // 공백을 기준으로 세 수를 잘라 줍니다.
			
			int n = Integer.parseInt(st.nextToken()); // 총 종이컵의 갯수
			int x = Integer.parseInt(st.nextToken()); // 사탕의 현재 위치
			int k = Integer.parseInt(st.nextToken()); // 종이컵 이동 횟수
			
			for(int i=0;i<k;i++) { // 종이컵 이동 횟수만큼 반복문 시작
				st = new StringTokenizer(br.readLine(), " "); // 이동시킬 두 종이컵 공백으로 나누고
				int a = Integer.parseInt(st.nextToken()); // 종이컵 1
				int b = Integer.parseInt(st.nextToken()); // 종이컵 2
				
				if( a == x ) { // 만약 종이컵 1이 현재 사탕의 위치와 같다면
					x= b;  // 현재 사탕의 위치를 종이컵 2로 갱신해줍니다.
				}
				else if( b== x) { // 마찬가지로 종이컵 1이 아니고 2와 현재 사탕의 위치가 같다면
					x= a; // 현재 사탕 위치를 종이컵 1로 갱신해줍니다.
				}
			}
			
			sb.append(x); // StringBuilder에 담습니다.
		
		System.out.println(sb); // 출력해줍니다.
		
		br.close();
		
	}

}
