import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        node[] arr = new node[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<n;i++){
            arr[i] = new node(i,Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int[] result = new int[n];

        int count = 0;

        for(int i=0;i<n;i++){
            result[arr[i].no] = count++;
        }
        for(int i=0;i<n;i++){
            sb.append(result[i] + " ");
        }

        System.out.println(sb);

    }

    public static class node implements Comparable<node>{
        int no;
        int value;

        public node(int no, int value){
            this.no = no;
            this.value = value;
        }

        @Override
        public int compareTo(node o){
            return this.value-o.value;
        }
    }


}
