import java.io.*;
import java.util.*;
public class Main{
public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int 에이 = Integer.parseInt(st.nextToken());
    int 비 = Integer.parseInt(st.nextToken());
    
    System.out.println(에이 + 비);
    
}
}