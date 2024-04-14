import java.io.*;
import java.util.*;


public class Main {

    public static node startNode = new node();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;
            int temp = Integer.parseInt(s);
            makeTree(temp);
        }
        solve(startNode);
        System.out.println(sb);


    }

    public static void solve(node target){
        if(target.left != null){
            solve(target.left);
        }

        if(target.right != null){
            solve(target.right);
        }

        sb.append(target.x + "\n");
    }

    public static void makeTree(int value) {
        node temp = startNode;
        while(true){
            if(temp.x == 0){
                temp.x = value;
                break;
            }
            if(temp.x<value){
                if(temp.right== null) temp.right = new node();
                temp = temp.right;
            }
            else{
                if(temp.left==null) temp.left = new node();
                temp =  temp.left;
            }
        }

    }

    public static class node {
        int x;
        node left;
        node right;

        node() {

        }

        node(int x) {
            this.x = x;
        }

    }

}