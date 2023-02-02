import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		
		if(w<1 || w>1000 || h<0 || h>1000) {
			System.out.println(" 1 ≤ w, h ≤ 1,000 ");
		}
		if(x<1 || x>=w) {
			System.out.println(" 1 ≤ x ≤ w-1 ");
		}
		if(y<1 || y>=h) {
			System.out.println(" 1 ≤ y ≤ h-1 ");
		}
		
		int w2 = Math.min(x, w-x);
		int h2 = Math.min(y, h-y);
		
		System.out.println(Math.min(w2, h2));
		
		

	}

}
