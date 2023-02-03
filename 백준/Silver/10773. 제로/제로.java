import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int sum=0;
		for(int i=0;i<N;i++) {
			int t = Integer.parseInt(br.readLine());
			
			if( t == 0 && !(list.isEmpty())) {
				int size = list.size();
				list.remove(size-1);
			}
			else {
				list.add(t);
			}
		}
		int size = list.size();
		
		for(int i=0;i<size;i++) {
			sum += list.get(i);
		}
		
		System.out.println(sum);
		br.close();
		
	}

}
