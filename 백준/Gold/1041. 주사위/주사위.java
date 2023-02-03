import java.io.*;
import java.util.*;

public class Main {
	
	public static int N;
	public static int[] dice = new int[6];
	public static int[] look = new int[3];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		int max = 0;
		int min = 51;
		
		for(int i=0;i<6;i++) {
			dice[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, dice[i]);
			if(min > dice[i]) {
				min = dice[i];
			}
			
		}
		
		look[0] = min;
		min = 101;
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<6;j++) {
				if((i+j) != 5) {
					int tempsum = dice[i]+dice[j];
					min = Math.min(min, tempsum);
				}
			}
		}
		
		look[1] = min;
		min = 151;
		for(int i=0;i<4;i++) {
			for(int j=i+1;j<5;j++) {
				for(int k=j+1;k<6;k++) {
					if((i+j) != 5) {
						if((j+k) != 5 && (i+k) != 5) {
							int tempsum = dice[i]+dice[j] + dice[k];
							min = Math.min(min, tempsum);
						}
						
					}
				}
			}
		}
		look[2] = min;
		
		long result = 0;
		
		// N == 1 
		if(N == 1) {
			for( int i=0; i<6; i++) {
				result += dice[i];
			}
			
			result -= max;
		}
		
		// N == 2
		else if(N == 2) {
			result = (look[1] *4) + (look[2]*4);
		}
		
		else {
			long floor1 = (look[1]*4) + ((look[0]*(N-2))*4);
			floor1 = floor1*(N-1);
			
			long floorTop = (look[2]*4) + (look[1]*(N-2)*4) + ( look[0]*((long)Math.pow(N-2, (double)2) ) );  
			
			result = floor1 + floorTop;
		}
		
		System.out.println(result);
		
		
	}

}
