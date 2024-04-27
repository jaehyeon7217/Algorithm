import java.io.*;
import java.util.*;


public class Main {
    public static int size;
    public static char[] s, result;
    public static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine().toCharArray();
        size = s.length;
        result= new char[size];

        // 3등분
        for(int i=0;i<size-2;i++){
            char[] one = Arrays.copyOfRange(s,0,i+1);
            for(int j=i+1;j<size-1;j++){
                char[] two = Arrays.copyOfRange(s, i+1, j+1);
                char[] three = Arrays.copyOfRange(s, j+1, size);
                check(reverse(one),reverse(two),reverse(three));
            }
        }

        System.out.println(String.valueOf(result));

    }

    public static char[] reverse(char[] s){
        int charSize = s.length;
        char[] newChar = new char[charSize];
        for(int i=0; i<charSize;i++){
            newChar[i] =  s[charSize-i-1];
        }
        return newChar;
    }

    public static  void check(char[] one, char[] two, char[] three){
        StringBuilder sb = new StringBuilder();
        sb.append(one).append(two).append(three);
        char[] temp = sb.toString().toCharArray();

        if(!flag){
            result = temp;
            flag = true;
            return;
        }

        for(int i=0;i<size;i++){
            int a = temp[i]-'a';
            int b = result[i] -'a';

            if(a==b) continue;
            else if(a<b){
                result = temp;
                return;
            }else{
                return;
            }

        }
    }

}
