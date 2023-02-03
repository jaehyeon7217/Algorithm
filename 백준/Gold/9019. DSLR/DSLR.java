import java.util.*;
import java.io.*;

public class Main {
	
	public static int before, after;
	public static Queue<cal> queue = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	public static char[] af;
	public static String result;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T ; t++) {
			st = new StringTokenizer(br.readLine());
			before = Integer.parseInt(st.nextToken());
			after = Integer.parseInt(st.nextToken());
			
			af = trans(after);
			
			result = "";
			
			queue.offer(new cal(before));
			
			bfs();
			
			sb.append(result+"\n");
					
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
	
	
	public static class cal{
		int x;
		String b;
		
		cal(int x){
			this.x = x;
			this.b = "";
		}
		cal(int x, String b){
			this.x = x;
			this.b = b;
		}
		
	}
	
	public static void bfs() {
		boolean[] visit = new boolean[10000];
		visit[before] = true;
		
		while(!queue.isEmpty()) {
			cal temp = queue.poll();
			int flag = 0;

			// L
			char[] ch = trans(temp.x);
			
			String s1 = temp.b;
			char tc = ch[0];
			for(int j=0; j<3;j++) ch[j] = ch[j+1];
			ch[3] = tc;
			s1 = s1+"L";
			int c=0;
			for(int a=0;a<4;a++) {
				if(ch[a] != af[a]) {
					c=1;
					break;
				}
			}
			
			if( c == 0) {
				result = s1;
				queue.removeAll(queue);
				flag =1;
			}
			else {
				int i1 = Integer.parseInt(String.valueOf(ch));
				if(visit[i1] == false) {
					queue.offer(new cal(i1, s1));
					visit[i1] = true;
				}
			}
			
			
			//R
			if(flag == 0) {
				ch = trans(temp.x);
				String s2 = temp.b;
				char tc2 = ch[3];
				for(int j=3; j>0;j--) ch[j] = ch[j-1];
				ch[0] = tc2;
				s2 = s2+"R";
				c=0;
				for(int a=0;a<4;a++) {
					if(ch[a] != af[a]) {
						c=1;
						break;
					}
				}
				
				if( c == 0) {
					result = s2;
					queue.removeAll(queue);
					flag =1;
				}
				else {
					int i2 = Integer.parseInt(String.valueOf(ch));
					if(visit[i2] == false) {
						queue.offer(new cal(i2, s2));
						visit[i2] = true;
					}
				}
				
			}
			

				
			
			// D
			if(flag == 0) {
				int tempX = temp.x*2;
				String tempS = temp.b + "D";
				if(tempX >9999) {
					tempX = tempX % 10000;
				}
				
				if( tempX == after) {
					result  = tempS;
					queue.removeAll(queue);
					flag = 1;
				}
				if( tempX != after && visit[tempX] == false){
					queue.offer(new cal(tempX, tempS));
					visit[tempX]= true;
				}
			}
		
			
			// S
			if(flag == 0) {
				int tempX = temp.x-1;
				String tempS = temp.b + "S";
				
				if(tempX<0) tempX = 10000-1;
				
				if(tempX == after) {
					result = tempS;
					queue.removeAll(queue);
				}
				if( tempX != after && visit[tempX] == false){
					queue.offer(new cal(tempX, tempS));
					visit[tempX] = true;
				}
			}
		}
	}
	
	
	public static char[] trans(int x) {
		char[] temp = String.valueOf(x).toCharArray();
		char[] c = new char[4];
		int beSize = temp.length;
		if(beSize < 4) {
			for(int i=0; i<4-beSize ; i++) {
				c[i] = '0';
			}
			for(int i=0;i<beSize;i++) {
				c[4-beSize+i] = temp[i]; 
			}
		}
		else {
			return temp;
		}
		
		return c;
	}
	
	public static void view(char[] x) {
		for(int i = 0; i<4;i++) {
			System.out.print(x[i]);
		}
		System.out.println("");
	}
}
