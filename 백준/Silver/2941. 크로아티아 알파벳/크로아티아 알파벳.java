import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();

        int size = c.length;

        int count = 0;

        for(int i=0;i<size;i++){
            switch(c[i]){
                case 'c':
                    if(i+1<size){
                        switch(c[i+1]){
                            case '=' :
                            case '-' :
                                i+=1;
                                break;
                        }
                    }
                    break;
                case 'd':
                    if(i+1<size){
                        switch(c[i+1]){
                            case 'z':
                                if(i+2<size && c[i+2] == '='){
                                    i+=2;
                                }
                                break;
                            case '-':
                                i+=1;
                                break;
                        }
                    }
                    break;
                case 'l':
                case 'n':
                    if(i+1<size && c[i+1] == 'j'){
                        i+=1;
                    }
                    break;
                case 's':
                case 'z':
                    if(i+1<size && c[i+1] == '='){
                        i+=1;
                    }
                    break;
            }
            count++;
        }

        System.out.println(count);

    }



}