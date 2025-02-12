import java.io.*;
import java.util.*;

public class Main {

    public static int[][] board = new int[3][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int ans = 0;

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            board[x][y] = n;
            if(i>=2 && check(x,y,n)){
                ans = n;
                break;
            }
            n = n==1 ? 2:1;

        }
        System.out.println(ans);

    }

    public static boolean check(int x, int y, int n){
        int count = 0;
        //가로
        for(int i=0;i<3;i++){
            if(board[(x+i)%3][y] != n) break;
            count++;
        }
        if(count==3) return true;
        //세로
        count = 0;
        for(int i=0;i<3;i++){
            if(board[x][(y+i)%3] != n) break;
            count++;
        }
        if(count==3) return true;

        //대각선
        count=0;
        if(x==y) {
            for (int i = 0; i < 3; i++) {
                if(board[(x+i)%3][(y+i)%3] != n) break;
                count++;
            }
        }
        if(count == 3) return true;

        if(x + y == 2){
            if(board[0][2] == board[1][1] && board[2][0] == board[1][1] && board[1][1] == n) return true;
        }
        return false;
    }

}
