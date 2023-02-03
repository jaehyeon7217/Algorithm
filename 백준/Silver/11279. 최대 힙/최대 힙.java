import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Heap heap = new Heap(N);
		
		for(int i=0 ; i < N ; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				sb.append(heap.poll() + "\n");
			}
			else {
				heap.add(x);
			}
			
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	public static class Heap{
		int num[];
		int top = 0;
		
		Heap(int n){
			this.num = new int[n+1];
		}
		
		public void add(int x) {
			this.num[++this.top] = x;
			
			for(int i=top;i/2>0;i/=2) {
				if(num[i]>num[i/2]) {
					swap(i,i/2);
				}
				else {
					break;
				}
			}
		}
		
		public int poll() {
			
			if(top == 0) return 0;
			
			int result = num[1];
			
			num[1] = num[top];
			num[top--] = 0;
			
			for(int i=1;i*2<=top;) {
				if(num[i]> num[i*2] && num[i]> num[i*2+1]) break;
				else if(num[i*2+1]<num[i*2]) {
					swap(i,i*2);
					i = i*2;
				}
				else {
					swap(i,i*2+1);
					i = i*2+1;
				}
			}
			return result;
		}
		
		public void swap(int a, int b) {
			int temp = num[a];
			num[a] = num[b];
			num[b] = temp;
		}
	}

}
