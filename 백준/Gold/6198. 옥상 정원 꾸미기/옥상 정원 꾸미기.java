import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] ans = new int[n];

        Stack<node> stack = new Stack<>();

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek().height <= temp){
                node tempNode = stack.pop();

                ans[tempNode.num] = i-tempNode.num -1;
            }
            stack.add(new node(temp,i));

        }

        stack.pop();

        while(!stack.isEmpty()){
            node tempNode = stack.pop();

            ans[tempNode.num] = n-tempNode.num -1;
        }


        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=ans[i];
        }

        System.out.println(sum);

    }
    public static class node{
        int height;
        int num;

        public node(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }


}
