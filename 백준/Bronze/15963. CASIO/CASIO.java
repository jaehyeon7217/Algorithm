import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);

    public static void main(String[] args) throws Exception {
        long n = nextNum().longValue();
        long m = nextNum().longValue();

        System.out.println(n == m ? 1 : 0);
    }

    public static Double nextNum() throws Exception {
        st.nextToken();
        return st.nval;
    }

}
