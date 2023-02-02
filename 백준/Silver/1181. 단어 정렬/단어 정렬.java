import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int t = Integer.parseInt(st.nextToken());
		
		word[] w = new word[t];
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			w[i]= new word(st.nextToken());
		}
		
		Arrays.sort(w,(word a, word b) -> {return a.len == b.len ? a.w.compareTo(b.w) : a.len - b.len;});
		
		for(int i=0;i<t;i++) {
			
			if (i==0) sb.append(w[i].w + "\n");
			else if(i!=0 && !w[i].w.equals(w[i-1].w)) {
				sb.append(w[i].w + "\n");
			}
		}
		
		bw.write(sb.toString());
		
		
		bw.close();
		
		
	}
	public static class word{
		String w;
		int len;
		word(){
			
		}
		word(String w){
			this.w=w;
			this.len=w.length();
		}
	}
}