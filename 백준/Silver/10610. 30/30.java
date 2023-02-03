import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split(" ");
		
		char[] temp = a[0].toCharArray();
		int size = temp.length;
		
		int flag = 0;
		for(int i=0; i<size; i++) {
			if(temp[i] == '0') {
				flag = 1;
			}
		}
		
		if(flag == 0) {
			System.out.println("-1");
			br.close();
			System.exit(0);
		}
		
		Arrays.sort(temp);
		
		char[] result = new char[size];
		int sum =0;
		for(int i=1; i<=size; i++) {
			result[i-1] = temp[size-i];
			sum += result[i-1];
		}
		
		String b= String.valueOf(result);
		
		if(sum %3 == 0) {
			System.out.println(b);
		}
		else {
			System.out.println("-1");
		}
		

	}

}
