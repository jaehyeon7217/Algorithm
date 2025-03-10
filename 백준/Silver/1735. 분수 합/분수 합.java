import java.io.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(System.in);

    public static void main(String[] args) throws Exception {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();

        // 두 분수가 기약분수인지 확인

        while(true) {
            int temp = Math.min(a, b);
            boolean flag = true;
            for (int i = 2; i <= temp; i++) {
                if (a % i == 0 && b % i == 0) {
                    a /= i;
                    b /= i;
                    flag = false;
                    break;
                }
            }
            if(flag) break;
        }


        while(true) {
            int temp = Math.min(c, d);
            boolean flag = true;
            for (int i = 2; i <= temp; i++) {
                if (c % i == 0 && d % i == 0) {
                    c /= i;
                    d /= i;
                    flag = false;
                    break;
                }
            }
            if(flag) break;
        }


        int e = (a*d) + (b*c);
        int f = b*d;

        while(true) {
            int temp = Math.min(e, f);
            boolean flag = true;
            for (int i = 2; i <= temp; i++) {
                if (e % i == 0 && f % i == 0) {
                    e /= i;
                    f /= i;
                    flag = false;
                    break;
                }
            }
            if(flag) break;
        }

        System.out.println(e + " " + f);
    }






    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }


}
