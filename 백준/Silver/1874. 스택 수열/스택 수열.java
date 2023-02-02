import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] target = new int[n];
		ArrayList<Integer> before = new ArrayList<>();
		
		for(int i=0;i<n;i++){
			int t = Integer.parseInt(br.readLine());
			target[i] = t;
			before.add(i+1);
		}
		
		
		
		for(int i=0;i<n;i++) {
			int size = before.size();
			for(int j=0 ; j<=size ; j++) {
				if(stack.isEmpty() && !(before.isEmpty())) {
					stack.push(before.remove(0));
					sb.append("+\n");
				}
				else if(target[i] == stack.peek()) {
					stack.pop();
					sb.append("-\n");
					j=size+1;
				}
				else if(target[i] != stack.peek() && !(before.isEmpty())){
					stack.push(before.remove(0));
					sb.append("+\n");
				}
				else if(target[i] != stack.peek() && before.isEmpty()) {
					sb.setLength(0);
					sb.append("NO");
					bw.write(sb.toString());
					bw.close();
					br.close();
					System.exit(0);
					
				}
				
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
