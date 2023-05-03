import java.io.*;
import java.util.*;

public class Main {

    public static int n, count =0;

    public static node[] map;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new node[n];

        for(int i=0 ;i<n;i++){
            st = new StringTokenizer(br.readLine());

            map[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=123;i<=987; i++){
            boolean[] check = new boolean[10];
            char[] temp = String.valueOf(i).toCharArray();
            boolean flag = true;
            for(int j=0;j<3;j++){
                if(check[temp[j]-'0']){
                    flag = false;
                    break;
                }
                if( temp[j] == '0'){
                    flag = false;
                    break;
                }
                check[temp[j]-'0'] = true;
            }
            if(flag){
                boolean flag2 = true;
                for(int j=0;j<n;j++){
                    char[] no = String.valueOf(map[j].value).toCharArray();
                    int strike = 0;
                    int ball = 0;
                    for(int a=0;a<3;a++){
                        for(int b=0;b<3;b++){
                            if(temp[a] == no[b]){
                                if(a==b){
                                    strike++;
                                }else{
                                    ball++;
                                }
                            }
                        }
                    }
                    if(map[j].strike != strike || map[j].ball != ball){
                        flag2 = false;
                        break;
                    }
                }

                if(flag2) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static class node{
        int value;
        int strike;
        int ball;

        public node(int value, int strike, int ball) {
            this.value = value;
            this.strike = strike;
            this.ball = ball;
        }
    }

}
