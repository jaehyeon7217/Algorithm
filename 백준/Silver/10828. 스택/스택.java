import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			
			switch(str) {
			case "push" : int x = Integer.parseInt(st.nextToken()); stack.push(x); break;
			case "pop" : sb.append(stack.empty() ? -1 : stack.pop()).append("\n"); break;
			case "size" : sb.append(stack.size()).append("\n"); break;
			case "empty" : sb.append(stack.empty() ? 1 : 0).append("\n"); break;
			case "top" : sb.append(stack.empty() ? -1 : stack.peek()).append("\n"); break;
			}
		}
		System.out.println(sb.toString());
		
		
	}

}
