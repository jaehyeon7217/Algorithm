import java.io.*;
import java.util.*;

public class Main {
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String word = br.readLine();
		
		word = word.toUpperCase();
		
		int[] sum = new int[26];
		
		for(int i=0;i<word.length();i++) {
			sum[ word.charAt(i) - 'A']++;
		}
		
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=0;i<26;i++) {
			if(max<sum[i]) {
				max= sum[i];
				index = i;
			}
			else if(max == sum[i]) {
				index = -1;
			}
		}
		
		if(index == -1) {
			System.out.println("?");
		}
		else {
			System.out.println((char)(index + 'A'));
		}
		
	}
	
}