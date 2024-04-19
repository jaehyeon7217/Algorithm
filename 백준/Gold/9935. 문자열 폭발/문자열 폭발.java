import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();

        int cSize = c.length;
        int boomSize = boom.length;

        ArrayList<Character> list = new ArrayList<>();

        for(int i=0;i<cSize;i++){
            list.add(c[i]);

            if(list.size()<boomSize){
                continue;
            }


            if(c[i] == boom[boomSize-1]){
                boolean flag = true;
                int size = list.size();
                for(int j=0;j<boomSize;j++){
                    if(list.get(size-j-1) != boom[boomSize-1-j]){
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j=0;j<boomSize;j++){
                        list.remove(size-1-j);
                    }
                }
            }

        }

        if(list.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i));
            }
            System.out.println(sb);
        }

    }

}