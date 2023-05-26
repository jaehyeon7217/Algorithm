import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] n = br.readLine().toCharArray();
        int size = n.length;
        int sum = 0;
        for(int i=0; i<size;i++){
            if(n[i] == 'A' || n[i] == 'B' || n[i] == 'C'){
                sum+=3;
            }else if(n[i] == 'D' || n[i] == 'E' || n[i] == 'F'){
                sum+=4;
            }else if(n[i] == 'G' || n[i] == 'H' || n[i] == 'I'){
                sum+=5;
            }else if(n[i] == 'J' || n[i] == 'K' || n[i] == 'L'){
                sum+=6;
            }else if(n[i] == 'M' || n[i] == 'N' || n[i] == 'O'){
                sum+=7;
            }else if(n[i] == 'P' || n[i] == 'Q' || n[i] == 'R' || n[i] == 'S'){
                sum+=8;
            }else if(n[i] == 'T' || n[i] == 'U' || n[i] == 'V'){
                sum+=9;
            }else if(n[i] == 'W' || n[i] == 'X' || n[i] == 'Y' || n[i] == 'Z'){
                sum+=10;
            }
        }

        System.out.println(sum);

    }
}
