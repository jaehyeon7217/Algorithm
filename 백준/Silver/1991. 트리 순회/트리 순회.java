import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static int n;
	public static int node[][];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st ; 
		
		n = Integer.parseInt(br.readLine());
		
		node = new int[n][2];
	
		for(int i=0;i<n;i++) {
			node[i][0]=-1;
			node[i][1]=-1;
		}
		
		for(int i=0;i<n;i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			int no = st.nextToken().toCharArray()[0]-'A'; 
			
			for(int j=0;j<2;j++) {
			char temp = st.nextToken().charAt(0);
			if(temp != '.')
				node[no][j] = temp-'A';
			}
		}
		
		// 전위 순회
		func1(0);
		sb.append("\n");
		
		// 중위 순회
		func2(0);
		sb.append("\n");
		
		// 후위 순회
		func3(0);
		sb.append("\n");
		
		System.out.println(sb.toString());
	}
	
	public static void func1(int depth) {
		sb.append(Character.toChars(depth+'A'));
		if(node[depth][0] != -1) {
			func1(node[depth][0]);
		}
		if(node[depth][1] != -1) {
			func1(node[depth][1]);
		}
		return;
	}
	
	public static void func2(int depth) {
		if(node[depth][0] != -1) {
			func2(node[depth][0]);
		}
		sb.append(Character.toChars(depth+'A'));
		if(node[depth][1] != -1) {
			func2(node[depth][1]);
		}
		return;
	}
	
	public static void func3(int depth) {
		if(node[depth][0] != -1) {
			func3(node[depth][0]);
		}
		if(node[depth][1] != -1) {
			func3(node[depth][1]);
		}
		sb.append(Character.toChars(depth+'A'));
		return;
	}
	
}
