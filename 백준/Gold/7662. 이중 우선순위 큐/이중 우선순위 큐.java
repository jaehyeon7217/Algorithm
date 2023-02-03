import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int q = 0; q<N;q++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				char oper = st.nextToken().charAt(0);
				Integer index = Integer.parseInt(st.nextToken());
				
				if(oper == 'I') {
					map.put(index, map.getOrDefault(index, 0) + 1);
				}
				
				if(oper == 'D') {
					if(map.size() != 0) {
						int temp=0;
						if(index == 1) {
							temp = map.lastKey();
						}
						
						if(index == -1) {
							temp = map.firstKey();
						}
						int flag = map.get(temp);
						if(flag == 1) {
							map.remove(temp);
							
						}
						else {
							map.put(temp, flag -1);
						}
						
					}
				}
			}
			
			if(map.size() == 0) {
				sb.append("EMPTY\n");
			}
			else {
				
				sb.append(map.lastKey()+" "+ map.firstKey() +"\n");
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
