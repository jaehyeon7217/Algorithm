import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int count=1;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;

            sb.append("Group " + (count++) +"\n");

            String[][] s = new String[n][n];

            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<n;j++){
                    s[i][j] = st.nextToken();
                }
            }
            boolean flag = true;
            for(int i=0;i<n;i++){
                for(int j=1;j<n;j++){
                    if(s[i][j].equals("N")){
                        if(i-j <0){
                            sb.append(s[n+i-j][0] + " was nasty about " + s[i][0] + "\n");
                        }else{
                            sb.append(s[i-j][0] + " was nasty about " + s[i][0] + "\n");
                        }
                        flag = false;
                    }
                }
            }
            if(flag){
                sb.append("Nobody was nasty\n");
            }

            sb.append("\n");

        }
        System.out.println(sb);



    }

}
