import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int d = 0;
        if(!isFizzBuzz(a)){
            d = Integer.parseInt(a)+3;
        }else if(!isFizzBuzz(b)){
            d = Integer.parseInt(b)+2;
        }else{
            d = Integer.parseInt(c)+1;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if(d%3==0){
            flag = true;
            sb.append("Fizz");
        }
        if(d%5==0){
            flag = true;
            sb.append("Buzz");
        }

        if(!flag){
            System.out.println(d);
        }else{
            System.out.println(sb);
        }


    }

    public static boolean isFizzBuzz(String a){
        if(a.equals("FizzBuzz")){
            return true;
        }
        if(a.equals("Fizz")){
            return true;
        }
        if(a.equals("Buzz")){
            return true;
        }
        return false;
    }
}
