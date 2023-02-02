import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<String> originalList_1 = new ArrayList<>();
	static ArrayList<String> originalList_2 = new ArrayList<>();
	static ArrayList<String> newList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int flag = 2501;
		
		int originalSize = 64;

		String sample_1 = "WBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBW";
		String sample_2 = "BWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWB";
		for(int i=0;i<originalSize ; i++) {
			char[] temp_char = sample_1.toCharArray();
			String a= ""+temp_char[i];
			originalList_1.add(a);
		}
		for(int i=0;i<originalSize ; i++) {
			char[] temp_char = sample_2.toCharArray();
			String a= ""+temp_char[i];
			originalList_2.add(a);
		}
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			char[] chararr = str.toCharArray();
			for(int j=0; j<m;j++) {
				String a = ""+chararr[j];
				newList.add(a);
			}
		}
		
		int temp;
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				temp = find(i,j,m);
				
				flag = Math.min(flag, temp);
			}
			
		}

		
		bw.write(flag+"\n");
		bw.close();
		

	}

	
	public static int find(int x, int y, int m) {
		
		int arrayFlag = 0;
		int temp_1 = 0;
		int temp_2 =0;
		
		for(int i=x; i<x+8;i++) {
			for(int j=y; j<y+8; j++) {
				int now = i*m+j;
					if(newList.get(now).charAt(0) != originalList_1.get(arrayFlag).charAt(0)) {
						temp_1++;
					}
				

					if(newList.get(now).charAt(0) != originalList_2.get(arrayFlag).charAt(0)) {
						temp_2++;
					}
				
				arrayFlag++;
				
			}
		}
		return Math.min(temp_1, temp_2);
	}
}
