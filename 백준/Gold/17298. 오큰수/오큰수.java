import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Arrays.fill(arr,-1);

        st= new StringTokenizer(br.readLine(), " ");

        Stack<node> stack = new Stack<>();

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().height<temp){
                node tempNode = stack.pop();
                arr[tempNode.num] = temp;
            }

            stack.push(new node(i, temp));

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);


    }
    public static class node{
        int num;
        int height;

        public node(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }


}
