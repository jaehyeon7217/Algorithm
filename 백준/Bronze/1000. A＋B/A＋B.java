import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(System.in);
        
        st.nextToken();
        int a = (int)st.nval;
        st.nextToken();
        int b = (int)st.nval;

        System.out.println(a+b);
    }


}