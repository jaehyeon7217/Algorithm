import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();


        char[][] s = new char[5][];

        int maxSize= 0;
        for(int i=0;i<5;i++){
            s[i] = br.readLine().toCharArray();
            maxSize = Math.max(maxSize,s[i].length);
        }

        for(int j=0; j<maxSize;j++){
            for(int i=0;i<5;i++){
                if(s[i].length>j){
                    sb.append(s[i][j]);
                }
            }
        }
        System.out.println(sb.toString());

    }


}