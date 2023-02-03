import java.io.*;
import java.util.*;

public class Main {
	
	public static int n,s, sum=0, count=0;  // n : 배열크기, s : 구해야하는 합, sum : 더한 수 저장, count : s와 sum이 같아지는 횟수
	public static int[] line; // 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		line = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) line[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++) sumA(i, 0); // 1개, 2개, 3개, 4개, 5개 --- n개를 선택하는 부분집합
		
		System.out.println(count); // 카운트 출력

	}
	
	// 매개면수 depth : 남은 부분수열 선택 갯수, start : 중복 제거를 위해서 앞에서 뽑은 수 이하는 가지 않음.
	public static void sumA(int depth, int start) { 
		if(depth == 0) {
			if(sum == s) count++; // 부분수열의 합이 목표 s 와 같다면 count++;
			return;
		}
		for(int i=start;i<n;i++) {  // start부터 탐색 시작.
				sum+=line[i]; // 더해주고
				sumA(depth-1, i+1); // 호출하고
				sum-=line[i]; // 원래대로 되돌린다. (빽트래킹?)
		}
	}
}
