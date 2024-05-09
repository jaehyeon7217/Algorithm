import java.io.*;
import java.util.*;

public class Main {

    public static final int mod = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        long result = 0;
        for(int T=0;T<t; T++){
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            long num = (func(n,mod-2)*s)%mod;

            result = (result+num)%mod;

        }

        System.out.println(result);

    }
    public static long func(int a, int n){
        if(n==1){
            return a%mod;
        }
        long num = (func(a,n/2))%mod;
        if(n%2 == 0){
            return (num*num)%mod;
        }else{
            return (((num*num)%mod)*(a%mod))%mod;
        }
    }

}
