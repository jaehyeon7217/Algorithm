import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] arr1, arr2;

        while(T-- > 0){
            arr1 = new int[26];
            arr2 = new int[26];
            st = new StringTokenizer(br.readLine(), " ");

            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();

            func(a,arr1);
            func(b,arr2);

            boolean flag = true;
            for(int i=0;i<26;i++){
                if(arr1[i] != arr2[i]){
                    flag = false;
                    break;
                }
            }

            sb.append(flag ? "Possible\n" : "Impossible\n");

        }

        System.out.println(sb);

    }

    public static void func(char[] a, int[] b){
        for(int i=0;i<a.length;i++){
            b[a[i]-'a']++;
        }
    }


}
