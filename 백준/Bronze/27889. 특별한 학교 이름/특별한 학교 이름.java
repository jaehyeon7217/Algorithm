import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        String s = next();

        switch(s){
            case "NLCS" : sb.append("North London Collegiate School"); break;
            case "BHA" : sb.append("Branksome Hall Asia"); break;
            case "KIS" : sb.append("Korea International School"); break;
            case "SJA" : sb.append("St. Johnsbury Academy"); break;
        }

        System.out.println(sb);

    }

    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
    public static String next() throws Exception{
        st.nextToken();
        return st.sval;
    }

}
