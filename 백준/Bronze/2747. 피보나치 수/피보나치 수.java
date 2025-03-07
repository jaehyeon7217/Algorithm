import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);

    public static int n, arr[];

    public static void main(String[] args) throws Exception {
        n = nextInt();

        arr= new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);


    }

    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

}
