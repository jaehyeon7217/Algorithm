import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] number = new int[N];
		int[] count = new int[8001];
		
		int max=-4001;
		int min = 4001;
		double sum = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			sum+= t;
			max = Math.max(max, t);
			min = Math.min(min, t);
			number[i] = t;
			count[t+4000]++;
			
		}
		
		sb.append(Math.round((sum/N))).append("\n");
		Arrays.sort(number);
		sb.append(number[(number.length-1)/2]).append("\n");
		
		int max1 = 0;
		
		for(int i=0; i<8001;i++) {
			max1 = Math.max(max1, count[i]);
		}
		
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=0; i<8001;i++) {
			if(count[i] == max1) {
				temp.add (i-4000);
			}
		}
		
		if( temp.size()>=2) {
			Collections.sort(temp);
			sb.append(temp.get(1)).append("\n");
		}
		else if( temp.size()== 1){
			sb.append(temp.get(0)).append("\n");
		}
		
		
		sb.append((max-min)).append("\n");
		
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}
