import java.io.*;
import java.util.*;

public class Main {

	public static LinkedList<Integer> list = new LinkedList<>();
	public static int plusCount = 0, minusCount = 0, result = Integer.MAX_VALUE, opersize = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine();

		int size = num.length();

		int flag = 0;
		
		int tempPlus = 0;
		for (int i = 0; i < size; i++) {
			char temp = num.charAt(i);
			if(temp == '+') {
				tempPlus += Integer.parseInt(num.substring(flag,i));
				flag = i+1;
			}
			else if(temp == '-') {
				tempPlus += Integer.parseInt(num.substring(flag,i));
				flag = i+1;
				list.add(tempPlus);
				tempPlus = 0;
			}
		}
		tempPlus += Integer.parseInt(num.substring(flag,size));
		list.add(tempPlus);
		
		result = list.poll();
		while(!list.isEmpty()) {
			result -= list.poll();
		}
		
		System.out.println(result);

		br.close();

	}

	

}