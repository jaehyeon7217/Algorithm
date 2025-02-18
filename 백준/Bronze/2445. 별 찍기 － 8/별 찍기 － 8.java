import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<n;i++){

            for(int j=0;j<n;j++){
                if(j<i){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            for(int j=n-1;j>=0;j--){
                if(j<i){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            sb.append("\n");

        }
        for(int i=0;i<n*2;i++){
            sb.append("*");
        }
        sb.append("\n");

        for(int i=n-1;i>0;i--){

            for(int j=0;j<n;j++){
                if(j<i){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            for(int j=n-1;j>=0;j--){
                if(j<i){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }


}
