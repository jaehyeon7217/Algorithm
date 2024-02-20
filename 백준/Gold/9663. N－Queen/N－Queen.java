import java.io.*;

public class Main {
	public static int N;
	public static int count=0;
	public static int[] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		for(int i=0;i<N;i++) {
			dfs(N,i);
		}
		
		System.out.println(count);
		
			
	}
	
	public static void dfs(int a, int index) {
		if((a-1) == 0){
			count++;
		}
		
			board[N-a] = index;
			
			possibility(a-1);
	}
	
	public static void possibility(int a) {
		
		int flag = 0;
		
		for(int j= 0; j<N; j++) {
		
			for(int i=0; i<(N-a);i++) {
				if(j == board[i]) {
					flag = 1;
					break;
				}
				if(board[i]-(N-a)+i>=0) {
					if(j == (board[i]-(N-a)+i)) {
						flag = 1;
						break;
					}
				}
				if(board[i]+(N-(a)-i)<N) {
					if(j == (board[i]+(N-a)-i)) {
						flag = 1;
						break;
					}
				}
			}
			
			if(flag == 0) {
				dfs(a,j);
			}
			flag = 0;
		}
	}
}
