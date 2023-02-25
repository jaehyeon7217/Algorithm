import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static ArrayList<Integer>[] map;
    public static int[] result;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n];
        result = new int[n];
        for(int i=0;i<n;i++) {
            map[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            map[start].add(end);
            map[end].add(start);

        }

        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i=0;i<map[temp].size();i++){
                int value = map[temp].get(i);
                if(result[value] == 0) {
                    result[value] = temp + 1;
                    q.add(value);
                }
            }
        }

        for(int i=1;i<n;i++){
            sb.append(result[i] + "\n");
        }

        System.out.println(sb.toString());

    }
}
