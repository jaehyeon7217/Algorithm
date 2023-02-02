import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stick = 64;
		int x = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(x!=0){
			
			if(stick == x) {
				x-=stick;
				count++;
			}
			
			if(stick/2 >= x) {
				stick = stick/2;
			}
			else if(stick/2 < x) {
				x = x-(stick/2);
				stick = stick/2;
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
