import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i] = br.readLine();
        }

        int len = s[0].length();

        int answer = 0;

        for(int i=0;i<n-1;i++){   // ((100*101)/2) * 50
            char[] a = s[i].toCharArray();
            for(int j=i+1;j<n;j++){
                char[] b = s[j].toCharArray();

                int[] arrA = new int[26];
                int[] arrB = new int[26];

                Arrays.fill(arrA, -1);
                Arrays.fill(arrB, -1);

                int flag = 1;

                for(int k = 0; k <len; k++){
                    int numA = a[k] - 'a';
                    int numB = b[k] - 'a';

                    if(arrA[numA]== -1 && arrB[numB] == -1){
                        arrA[numA] = numB;
                        arrB[numB] = numA;
                    }else{
                        if(arrA[numA] != -1){
                            if(!check(arrA[numA] , numB)){
                                flag = 0;
                                break;
                            }
                        }else{
                            if(!check(arrB[numB], numA)){
                                flag = 0;
                                break;
                            }
                        }
                    }

                }

                if(flag == 1){
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    public static boolean check(int a, int b){
        return a==b ? true : false;
    }

}
