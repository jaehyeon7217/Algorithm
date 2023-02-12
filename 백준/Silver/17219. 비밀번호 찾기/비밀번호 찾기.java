import java.io.*;
import java.util.*;

public class Main {

    public static int n,m;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0;i<m;i++){
            sb.append(map.get(br.readLine()) + "\n");
        }

        System.out.println(sb.toString());
    }
}
